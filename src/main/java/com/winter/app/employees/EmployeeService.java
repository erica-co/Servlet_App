package com.winter.app.employees;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.Action;

import com.winter.app.ActionForward;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		employeeDAO = new EmployeeDAO();
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO session = (EmployeeDTO)request.getSession().getAttribute("user");
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setEmployee_id(session.getEmployee_id());
		
		int result = employeeDAO.update(employeeDTO);
		
		actionForward.setFlag(false);
		actionForward.setPath("./mypage.do");
	} 
	
	public void updateProcess(HttpServletRequest request, ActionForward actionForward) throws Exception {
		
	}
	
	
	public void detail(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = (EmployeeDTO)request.getSession().getAttribute("user");
		
		EmployeeDTO result =	employeeDAO.detail(employeeDTO);
		request.setAttribute("user", result);
	}
	
	public void login(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Long.parseLong(request.getParameter("employee_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO = employeeDAO.login(employeeDTO);
		
		if(employeeDTO !=null) {
			//index
			HttpSession session =  request.getSession();
			
			session.setAttribute("user", employeeDTO);
			actionForward.setFlag(false);
			actionForward.setPath("../index.do");
		}else {
			//
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "./login.do");
			actionForward.setFlag(true);
			actionForward.setPath("WEB-INF/views/commons/result.jsp");
			
		}
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Long.parseLong(request.getParameter("employee_id")));
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setEmail(request.getParameter("email"));
		employeeDTO.setCommission_pct(Long.parseLong("commission_pct"));
		employeeDTO.setJob_id(request.getParameter("job_id"));
		employeeDTO.setSalary(Double.parseDouble(request.getParameter("salary")));
		employeeDTO.setManager_id(Long.getLong(request.getParameter("manager_id")));
		employeeDTO.setPhone_number(request.getParameter("phone_number"));
		employeeDTO.setDepartment_id(Long.parseLong(request.getParameter("department_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		
		//int result = employeeDAO.add(employee);
		
		
		
		
	}
}
