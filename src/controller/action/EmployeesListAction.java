package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class EmployeesListAction implements Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		List<EmployeesVO> list =  eDao.selectAllEmployees();
		request.setAttribute("employees", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/employeesList.jsp");
		dispatcher.forward(request, response);
	}

}
