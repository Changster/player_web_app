package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.CrudBO;
import com.bo.CrudBOImpl;
import com.exception.BusinessException;
import com.model.Player;

/**
 * Servlet implementation class RegisterPlayerController
 */
public class RegPlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegPlayerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		Player player = (Player) session.getAttribute("player");
		System.out.println(player);
		player.setDob();
		CrudBO crudBO = new CrudBOImpl();
		try {
			if (crudBO.regPlayer(player) != null) {
				System.out.println("Player registered: " + player);
				rd = request.getRequestDispatcher("login.html");
				request.setAttribute("message", "Success");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("regPlayer.jsp");
				request.setAttribute("errorMessage", "Error Occurred");
				rd.forward(request, response);
			}
		} 
		catch (BusinessException e) {
			if(e.getMessage().contains("EMAIL_UNIQUE_CON")) {
				rd = request.getRequestDispatcher("regPlayer.jsp");
				request.setAttribute("errorMessage", "Email is already registered");
				rd.forward(request, response);
			}
			else if(e.getMessage().contains("CONTACT_UNIQUE_CON")) {
				rd = request.getRequestDispatcher("regPlayer.jsp");
				request.setAttribute("errorMessage", "Contact is already registered");
				rd.forward(request, response);
			}
		}
	}
}
