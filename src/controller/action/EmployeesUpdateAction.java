package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class EmployeesUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		EmployeesVO eVo = new EmployeesVO();
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		eVo.setId(id);
		eVo.setPass(pass);
		eVo.setGender(gender);
		eVo.setName(name);
		eVo.setPhone(phone);
		eVo.setLev(lev);
		
		eDao.updateEmployees(eVo);
		response.sendRedirect("EmployeesServlet?command=employees_list");
	}

}
