package controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class EmployeesInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		EmployeesVO eVo = new EmployeesVO();
		
		String path = "upload";
		String uploadPath = request.getSession().getServletContext().getRealPath(path);
		int limitSize = 20 * 1024 * 1024;
		String encType = "UTF-8";
		
		System.out.println(uploadPath);
		MultipartRequest multi = new MultipartRequest(request,
					uploadPath,
					limitSize,
					encType,
					new DefaultFileRenamePolicy());
			eVo.setId(multi.getParameter("id"));
			eVo.setName(multi.getParameter("name"));
			eVo.setPass(multi.getParameter("pass"));
			eVo.setGender(multi.getParameter("gender"));
			eVo.setPhone(multi.getParameter("phone"));
			eVo.setLev(multi.getParameter("lev"));
			eVo.setPicture(multi.getParameter("picture"));
		

		new EmployeesListAction().execute(request, response);

	}

}
