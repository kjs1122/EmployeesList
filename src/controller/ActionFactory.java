package controller;

import controller.action.Action;
import controller.action.CheckPassAction;
import controller.action.CheckPassActionForm;
import controller.action.EmployeesDeleteAction;
import controller.action.EmployeesInsertAction;
import controller.action.EmployeesInsertActionForm;
import controller.action.EmployeesListAction;
import controller.action.EmployeesUpdateAction;
import controller.action.EmployeesUpdateActionForm;
import controller.action.EmployeesViewAction;

public class ActionFactory {
	
	private ActionFactory() {
		
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public static Action getAction(String command) {
		Action action = null;
		if(command.equals("employees_list")) {
			action = new EmployeesListAction();
		}
		if(command.equals("employees_view")) {
			action = new EmployeesViewAction();
		}
		if(command.equals("employees_insert_form")) {
			action = new EmployeesInsertActionForm();
		}
		if(command.equals("employees_insert")) {
			action = new EmployeesInsertAction();
		}
		if(command.equals("check_pass_form")) {
			action = new CheckPassActionForm();
		}
		if(command.equals("check_pass")) {
			action = new CheckPassAction();
		}
		if(command.equals("employees_update_form")) {
			action = new EmployeesUpdateActionForm();
		}
		if(command.equals("employees_update")) {
			action = new EmployeesUpdateAction();
		}
		if(command.equals("employees_delete")) {
			action = new EmployeesDeleteAction();
		}
		
		return action;
	}

}
