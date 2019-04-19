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
 * Servlet implementation class DeletePlayerController
 */
public class DeletePlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("playId");
		RequestDispatcher rd = null;
		System.out.println(id);
		CrudBO crudBO = new CrudBOImpl();
		try {
			if(crudBO.deletePlayer(id) != 0) {
				System.out.println("Player deleted");
				rd = request.getRequestDispatcher("deletePlayer.jsp");
				request.setAttribute("message", "Success");
				rd.forward(request, response);
			}
			else {
				rd = request.getRequestDispatcher("deletePlayer.jsp");
				request.setAttribute("errorMessage", "ID Not Found");
				rd.include(request, response);
			}
		} catch (BusinessException e) {
			rd = request.getRequestDispatcher("deletePlayer.jsp");
			request.setAttribute("errorMessage", e.getMessage());
			rd.include(request, response);
		}
	}

}
