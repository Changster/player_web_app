package com.bo;

import java.util.Date;
import java.util.List;

import com.dao.SearchDAO;
import com.dao.SearchDAOImpl;
import com.exception.BusinessException;
import com.model.Player;

public class SearchBOImpl implements SearchBO {
	
	private SearchDAO searchDAO;

	@Override
	public Player getPlayerById(String id) throws BusinessException {
		Player player = null;
		if(id.matches("[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}.[A-Za-z0-9]{1,}")) {
			searchDAO = getSearchDAO();
			player = searchDAO.getPlayerById(id);
		}else {
			throw new BusinessException(id + " is an invalid id");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BusinessException {
		List<Player> playerList = null;
		
		searchDAO = getSearchDAO();
		playerList = searchDAO.getPlayersByName(name);
		
		return playerList;
	}

	@Override
	public Player getPlayerByEmail(String email) throws BusinessException {
		Player player = null;
		if(email.matches("[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}.com")) {
			searchDAO = getSearchDAO();
			player = searchDAO.getPlayerByEmail(email);
		}else {
			throw new BusinessException(email + " is an invalid email");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByDob(Date dob) throws BusinessException {
		List<Player> playerList = null;
	
		searchDAO = getSearchDAO();
		
		if(dob != null)
			playerList = searchDAO.getPlayersByDob(dob);
		
		return playerList;
	}

	@Override
	public Player getPlayerByContact(Long contact) throws BusinessException {
		Player player = null;
		if(contact.toString().length() == 10) {
			searchDAO = getSearchDAO();
			player = searchDAO.getPlayerByContact(contact);
		}else {
			throw new BusinessException(contact + " must be length 10");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerList = null;
		if(gender.matches("M|m|F|f")) {
			searchDAO = getSearchDAO();
			playerList = searchDAO.getPlayersByGender(gender);
		}
		else {
			throw new BusinessException("bad gender");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamname) throws BusinessException {
		List<Player> playerList = null;
		if(teamname.matches("[A-Za-z ]{3,15}")) {
			searchDAO = getSearchDAO();
			playerList = searchDAO.getPlayersByTeamName(teamname);
		}
		else {
			throw new BusinessException("bad teamname");
		}
		return playerList;
	}

	public SearchDAO getSearchDAO() {
		if(searchDAO == null) {
			searchDAO = new SearchDAOImpl();
		}
		return searchDAO;
	}

}
