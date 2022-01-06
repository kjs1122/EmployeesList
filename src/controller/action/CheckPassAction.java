package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class CheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String url = null;
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		EmployeesVO eVo = eDao.selectEmployeesById(id);
		
		if(pass.equals(eVo.getPass())) {
			url = "/board/checkSuccess.jsp";
		} else {
			url = "/board/checkPassForm.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
			request.getRequestDispatcher(url).forward(request, response);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
