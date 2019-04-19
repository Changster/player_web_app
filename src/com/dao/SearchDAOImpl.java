package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbutil.OracleDBConnection;
import com.exception.BusinessException;
import com.model.Player;

public class SearchDAOImpl implements SearchDAO {

	@Override
	public Player getPlayerById(String id) throws BusinessException {
		Player player = null;
		try (Connection connection = OracleDBConnection.getConnection()) {

			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id where p.id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id.toUpperCase());
			ResultSet resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				player = new Player();
				player.setId(id);
				player.setName(resultset.getString("name"));
				player.setDob(resultset.getDate("dob"));
				player.setEmail(resultset.getString("email"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setTeamname(resultset.getString("teamname"));
			} else {
				throw new BusinessException("Error getting player by id: " + id);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error for getPlayerById");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = OracleDBConnection.getConnection()) {

			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id where p.name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				Player player = new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setDob(resultset.getDate("dob"));
				player.setEmail(resultset.getString("email"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setTeamname(resultset.getString("teamname"));
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("Name not found: " + name);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error for getPlayerByName");
		}
		return playerList;
	}

	@Override
	public Player getPlayerByEmail(String email) throws BusinessException {
		Player player = null;
		try (Connection connection = OracleDBConnection.getConnection()) {

			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id where p.email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				player = new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setDob(resultset.getDate("dob"));
				player.setEmail(resultset.getString("email"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setTeamname(resultset.getString("teamname"));
			} else {
				throw new BusinessException("Error getting player by email: " + email);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error for getPlayerById");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByDob(Date dob) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = OracleDBConnection.getConnection()) {

			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id where p.dob = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(dob.getTime()));
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				Player player = new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setDob(resultset.getDate("dob"));
				player.setEmail(resultset.getString("email"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setTeamname(resultset.getString("teamname"));
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("Date of Birth not found: " + dob);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error for getPlayerByDob");
		}
		return playerList;
	}

	@Override
	public Player getPlayerByContact(Long contact) throws BusinessException {
		Player player = null;
		try (Connection connection = OracleDBConnection.getConnection()) {

			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id where p.contact = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, contact);
			ResultSet resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				player = new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setDob(resultset.getDate("dob"));
				player.setEmail(resultset.getString("email"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setTeamname(resultset.getString("teamname"));
			} else {
				throw new BusinessException("Error getting player by contact: " + contact);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error for getPlayerById");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = OracleDBConnection.getConnection()) {

			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id where p.gender = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gender);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				Player player = new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setDob(resultset.getDate("dob"));
				player.setEmail(resultset.getString("email"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setTeamname(resultset.getString("teamname"));
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("Gender not found: " + gender);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error for getPlayerByGender");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamname) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = OracleDBConnection.getConnection()) {

			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, t.teamname from player p join teams t on p.team_id = t.team_id where t.teamname = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teamname);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				Player player = new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setDob(resultset.getDate("dob"));
				player.setEmail(resultset.getString("email"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setTeamname(teamname);
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("Team has no players");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error");
		}
		return playerList;
	}

}
