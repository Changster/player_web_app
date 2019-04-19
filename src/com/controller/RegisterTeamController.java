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
import com.model.Team;

/**
 * Servlet implementation class RegisterTeamController
 */
public class RegisterTeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterTeamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);
		Team team = (Team) session.getAttribute("team");
		System.out.println(team);
		CrudBO crudBO = new CrudBOImpl();
		try {
			if (crudBO.addTeam(team) != null) {
				System.out.println("Player added: " + team);
				rd = request.getRequestDispatcher("addTeam.jsp");
				request.setAttribute("message", "Success");
				rd.forward(request, response);
				
			} else {
				rd = request.getRequestDispatcher("addTeam.jsp");
				request.setAttribute("errorMessage", "Error Occurred");
				rd.forward(request, response);
			}
		} 
		catch (BusinessException e) {
			if(e.getMessage().contains("TEAMS_PK")) {
				rd = request.getRequestDispatcher("addTeam.jsp");
				request.setAttribute("errorMessage", "Team ID is already in use");
				rd.forward(request, response);
			}
			else {
				rd = request.getRequestDispatcher("addTeam.jsp");
				request.setAttribute("errorMessage", e.getMessage());
				rd.forward(request, response);
			}

		}
	}

}
