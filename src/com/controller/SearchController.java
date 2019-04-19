package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.SearchBO;
import com.bo.SearchBOImpl;
import com.exception.BusinessException;
import com.model.Player;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchBO searchBO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public SearchBO getSearchBO() {
		if(searchBO == null) {
			searchBO = new SearchBOImpl();
		}
		return searchBO;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ch = Integer.parseInt(request.getParameter("criteria"));
		try {
			searchBO = getSearchBO();
			String headers[] = {"Player ID", "Player Name", "Player DOB", "Player Email", "Player Gender", "Team Name", "Player Contact"};
			switch (ch) {
			case 1:
				String id = request.getParameter("searchValue");
				Player player = searchBO.getPlayerById(id);
				if(player != null) {
					List<Player> playerList = new ArrayList<>();
					playerList.add(player);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList);
					response.sendRedirect("results.jsp");
				}
	
				break;
				
			case 2:
				String name = request.getParameter("searchValue");
				List<Player> playerList = searchBO.getPlayersByName(name);
				if(playerList != null && playerList.size() > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList);
					response.sendRedirect("results.jsp");
				}
						
				break;
				
			case 3:
				String dob = request.getParameter("searchValue");
				List<Player> playerList2 = searchBO.getPlayersByDob(new SimpleDateFormat("MM/dd/yyyy").parse(dob));
				if(playerList2 != null && playerList2.size() > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList2);
					response.sendRedirect("results.jsp");
				}
						
				break;
				
			case 4:
				String email = request.getParameter("searchValue");
				Player player2 = searchBO.getPlayerByEmail(email);
				if(player2 != null ) {
					List<Player> playerList6 = new ArrayList<>();
					playerList6.add(player2);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList6);
					response.sendRedirect("results.jsp");
				}
						
				break;
				
			case 5:
				String gender = request.getParameter("searchValue");
				List<Player> playerList3 = searchBO.getPlayersByGender(gender);
				if(playerList3 != null && playerList3.size() > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList3);
					response.sendRedirect("results.jsp");
				}
						
				break;
				
			case 6:
				String teamName = request.getParameter("dropd");
				List<Player> playerList4 = searchBO.getPlayersByTeamName(teamName);
				if(playerList4 != null && playerList4.size() > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList4);
					response.sendRedirect("results.jsp");
				}
						
				break;
				
			case 7:
				String contact = request.getParameter("searchValue");
				Player player3 = searchBO.getPlayerByContact(Long.parseLong(contact));
				if(player3 != null ) {
					List<Player> playerList9 = new ArrayList<>();
					playerList9.add(player3);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList9);
					response.sendRedirect("results.jsp");
				}
						
				break;
				
			default:
				throw new BusinessException("Invalid Search Choice");
			}
		}
		catch(BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("searchPlayer.jsp").include(request, response);
		} catch (ParseException e) {
			request.setAttribute("errorMessage", "Date must be in format: mm/dd/yyyy");
			request.getRequestDispatcher("searchPlayer.jsp").include(request, response);
		}
	}

}
