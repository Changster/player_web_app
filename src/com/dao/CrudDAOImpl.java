package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.OracleDBConnection;
import com.exception.BusinessException;
import com.model.Player;
import com.model.Team;

public class CrudDAOImpl implements CrudDAO {

	@Override
	public Player addPlayer(Player player) throws BusinessException{
		try (Connection connection = OracleDBConnection.getConnection()) {
			String sql = "{call ADDPLAYER(?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement call = connection.prepareCall(sql);
			call.registerOutParameter(1, java.sql.Types.VARCHAR);
			call.setString(2, player.getName());
			call.setDate(3, new java.sql.Date(player.getDob().getTime()));
			call.setString(4, player.getEmail());
			call.setString(5, player.getGender());
			call.setString(6, player.getTeamname());
			call.setLong(7, player.getContact());
			call.registerOutParameter(8, java.sql.Types.VARCHAR);

			call.execute();
			
			if(call.getString(8) == null) {
				player.setId(call.getString(1));
			}
			else {
				throw new BusinessException("error registering player");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage());
		} 
		return player;
	}
	
	@Override
	public Player regPlayer(Player player) throws BusinessException{
		try (Connection connection = OracleDBConnection.getConnection()) {
			String sql = "{call REGISTERPLAYER(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement call = connection.prepareCall(sql);
			call.registerOutParameter(1, java.sql.Types.VARCHAR);
			call.setString(2, player.getName());
			call.setDate(3, new java.sql.Date(player.getDob().getTime()));
			call.setString(4, player.getEmail());
			call.setString(5, player.getGender());
			call.setString(6, player.getTeamname());
			call.setLong(7, player.getContact());
			call.setString(8, player.getPassword());
			call.registerOutParameter(9, java.sql.Types.VARCHAR);

			call.execute();
			
			if(call.getString(9) == null) {
				player.setId(call.getString(1));
			}
			else {
				throw new BusinessException("error registering player");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage());
		} 
		return player;
	}

	@Override
	public int updatePlayer(String id, long contact) throws BusinessException {
		int c = 0;
		try (Connection connection = OracleDBConnection.getConnection()) {
			String sql = "update player set contact = ? where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, contact);
			ps.setString(2, id);
			c = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal Error");
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int deletePlayer(String id) throws BusinessException {
		int c = 0;
		try (Connection connection = OracleDBConnection.getConnection()) {
			String sql = "delete from player where id = ?";
			//String sql2 = "delete from playerlogin where username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			//PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps.setString(1, id);
			//ps2.setString(1, id);
			c = ps.executeUpdate();
			//ps2.execute();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal Error");
			throw new BusinessException(e.getMessage());
		}
		return c;
	}

	@Override
	public Team addTeam(Team team) throws BusinessException {
		try (Connection connection = OracleDBConnection.getConnection()) {
			String sql = "insert into teams values(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, team.getTeam_id());
			ps.setString(2, team.getTeamname());
			ps.setString(3, team.getCoachname());
			ps.execute();

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage());
			
		} 

		return team;
	}

	@Override
	public List<Player> viewPlayers() throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = OracleDBConnection.getConnection()) {
			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);
			
			while(rs.next()) {
				Player player = new Player();
				player.setId(rs.getString("id"));
				player.setName(rs.getString("name"));
				player.setDob(rs.getDate("dob"));
				player.setEmail(rs.getString("email"));
				player.setGender(rs.getString("gender"));
				player.setContact(rs.getLong("contact"));
				player.setTeamname(rs.getString("teamname"));
				
				playerList.add(player);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occurred");
		}
		return playerList;
	}

	@Override
	public List<Team> viewTeams() throws BusinessException {
		List<Team> teamList = new ArrayList<>();
		try (Connection connection = OracleDBConnection.getConnection()) {
			String sql = "select team_id, teamname, coachname from teams";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery(sql);
			
			while(resultset.next()) {
				Team team = new Team();
				team.setTeam_id(resultset.getInt("team_id"));
				team.setTeamname(resultset.getString("teamname"));
				team.setCoachname(resultset.getString("coachname"));
				
				teamList.add(team);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occurred");
		}
		return teamList;
	}

}
