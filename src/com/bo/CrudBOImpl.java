package com.bo;

import java.util.ArrayList;
import java.util.List;

import com.dao.CrudDAO;
import com.dao.CrudDAOImpl;
import com.exception.BusinessException;
import com.model.Player;
import com.model.Team;

public class CrudBOImpl implements CrudBO {

	private CrudDAO crudDAO;

	@Override
	public Player addPlayer(Player player) throws BusinessException {
		Player newplayer = null;
		crudDAO = getCrudDAO();

		if (player.getEmail().matches("[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}.[A-Za-z0-9]{1,}")) {
			if (Long.toString(player.getContact()).length() == 10) {
				if(player.getName().matches("[A-Za-z .-]{1,20}"))
				{
					newplayer = crudDAO.addPlayer(player);
				}
				else {
					throw new BusinessException("Name should only be letters. Max length 20");
				}
			}
			else {
				System.out.println("Contact should be length 10");
			}
		} else {
			System.out.println("Invalid email type");
		}

		return newplayer;
	}
	
	@Override
	public Player regPlayer(Player player) throws BusinessException {
		Player newplayer = null;
		crudDAO = getCrudDAO();

		if (player.getEmail().matches("[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}.[A-Za-z0-9]{1,}")) {
			if (Long.toString(player.getContact()).length() == 10) {
				if(player.getName().matches("[A-Za-z]{1,20}"))
				{
					newplayer = crudDAO.regPlayer(player);
				}
				else {
					throw new BusinessException("Name should only be letters. Max length 20");
				}
			}
			else {
				System.out.println("Contact should be length 10");
			}
		} else {
			System.out.println("Invalid email type");
		}

		return newplayer;
	}

	@Override
	public int updatePlayer(String id, long contact) throws BusinessException {
		int c = 0;
		crudDAO = getCrudDAO();
		
		try {
			if(id.matches("[Pp]{1}[A-Za-z]{2}[0-9]{7}")) {
				if (Long.toString(contact).length() == 10) {
					c = crudDAO.updatePlayer(id, contact);
				}
				else {
					System.out.println("Contact should be length 10");
				}
			}
			else {
				System.out.println("ID is not in correct format");
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return c;
	}

	@Override
	public int deletePlayer(String id) throws BusinessException {
		int c = 0;
		crudDAO = getCrudDAO();
		if(id.matches("[Pp]{1}[A-Za-z]{2}[0-9]{7}")) {
			c = crudDAO.deletePlayer(id);
		}
		else {
			throw new BusinessException("ID is not in correct format");
		}
		return c;
	}

	@Override
	public Team addTeam(Team team) throws BusinessException {
		Team newteam = null;
		crudDAO = getCrudDAO();
		if(team != null)
			newteam = crudDAO.addTeam(team);
		return newteam;
	}

	@Override
	public List<Player> viewPlayers() throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		crudDAO = getCrudDAO();
		playerList = crudDAO.viewPlayers();
		return playerList;
	}

	@Override
	public List<Team> viewTeams() throws BusinessException {
		List<Team> teamList = new ArrayList<>();
		crudDAO = getCrudDAO();
		teamList = crudDAO.viewTeams();
		return teamList;
	}

	public CrudDAO getCrudDAO() {
		if (crudDAO == null) {
			crudDAO = new CrudDAOImpl();
		}
		return crudDAO;
	}

}
