package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

import controller.action.EmployeesListAction;

/**
 * Servlet implementation class EmployeesUploadServlet
 */
@WebServlet("/EmployeesFileServlet")
public class EmployeesFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		EmployeesVO eVo = new EmployeesVO();
		
		String path = "upload";
		String uploadPath = request.getSession().getServletContext().getRealPath(path);
		int limitSize = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		
		MultipartRequest multi = new MultipartRequest(request,
					uploadPath,
					limitSize,
					encType,
					new DefaultFileRenamePolicy());
		String command = multi.getParameter("command");
			eVo.setId(multi.getParameter("id"));
			eVo.setName(multi.getParameter("name"));
			eVo.setPass(multi.getParameter("pass"));
			eVo.setGender(multi.getParameter("gender"));
			eVo.setPhone(multi.getParameter("phone"));
			eVo.setLev(multi.getParameter("lev"));
			eVo.setPicture(multi.getOriginalFileName("picture"));
			eVo.setFilename(multi.getFilesystemName("picture"));
			
			if(command.equals("employees_insert")) {
				eDao.insertEmployees(eVo);
			} else if (command.equals("employees_update")) {
				eDao.updateEmployees(eVo);
			}
		
		
		new EmployeesListAction().execute(request, response);

	}

		
	

}
