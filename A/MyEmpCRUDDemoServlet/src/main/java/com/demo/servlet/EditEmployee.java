package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Employee;
import com.demo.service.EmpService;
import com.demo.service.EmpServiceImpl;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/Editemp")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("eid"));
		EmpService eservice = new EmpServiceImpl();
		Employee e = eservice.getById(id);
		request.setAttribute("emp", e);
		RequestDispatcher rd = request.getRequestDispatcher("updateemp.jsp");
		rd.forward(request, response);
	}

}
