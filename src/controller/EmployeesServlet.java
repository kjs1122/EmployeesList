package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.action.Action;

/**
 * Servlet implementation class EmployeesServlet
 */
@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeesServlet() {
    	

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		action.execute(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
