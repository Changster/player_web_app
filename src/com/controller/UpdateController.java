package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.CrudBO;
import com.bo.CrudBOImpl;
import com.exception.BusinessException;

/**
 * Servlet implementation class UpdateController
 */
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("playId");
		RequestDispatcher rd = null;
		CrudBO crudBO = new CrudBOImpl();	
		long contact = 0;
		
		try {
			contact = Long.parseLong(request.getParameter("contact"));
			if(contact != 0 && crudBO.updatePlayer(id, contact) != 0) {
				System.out.println("player updated: " + id);
				rd = request.getRequestDispatcher("updatePlayer.jsp");
				request.setAttribute("message", "Success");
				rd.include(request, response);
			}
			else {
				rd = request.getRequestDispatcher("updatePlayer.jsp");
				request.setAttribute("errorMessage", "Error Occurred");
				rd.include(request, response);
			}
		} catch (BusinessException  | NumberFormatException e) {
			rd = request.getRequestDispatcher("updatePlayer.jsp");
			request.setAttribute("errorMessage", "Incorrect Fields");
			rd.include(request, response);
		}
		
	}

}
