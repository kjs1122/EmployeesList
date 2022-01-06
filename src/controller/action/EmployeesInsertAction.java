package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class EmployeesInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		EmployeesVO eVo = new EmployeesVO();
		
		eVo.setId(request.getParameter("id"));
		eVo.setName(request.getParameter("name"));
		eVo.setPass(request.getParameter("pass"));
		eVo.setGender(request.getParameter("gender"));
		eVo.setPhone(request.getParameter("phone"));
		eVo.setLev(request.getParameter("lev"));
		
		eDao.insertEmployees(eVo);
		
		new EmployeesListAction().execute(request, response);

	}

}
