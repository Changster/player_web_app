package com.bo;

import java.util.List;

import com.exception.BusinessException;
import com.model.Player;
import com.model.Team;

public interface CrudBO {
	
	public Player addPlayer(Player player) throws BusinessException;
	public Player regPlayer(Player player) throws BusinessException;
	public int updatePlayer(String id, long contact) throws BusinessException;
	public int deletePlayer(String id) throws BusinessException;
	public Team addTeam(Team team) throws BusinessException;
	public List<Player> viewPlayers() throws BusinessException;
	public List<Team> viewTeams() throws BusinessException;

}
