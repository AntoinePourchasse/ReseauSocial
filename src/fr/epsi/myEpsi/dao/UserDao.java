package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;

public class UserDao implements IUserDao {

	Connection con = ConnectionTool.getConnection();
	@Override
	public List<User> getListOfUsers() {
		List<User> users = new ArrayList<>();
		if(con != null){
			try {
				Statement stmt = con.createStatement();
				ResultSet result=stmt.executeQuery("SELECT * FROM USERS");
				while (result.next()){
					User user = new User();
					user.setId(result.getString(1));
					user.setPassword(result.getString(2));
					user.setAdministrator(result.getBoolean(3));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return users;
		}
		else
			return null;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		User user = new User();
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery("SELECT * FROM USERS WHERE ID = " + id);
				while (result.next()){
					user.setId(result.getString(1));
					user.setPassword(result.getString(2));
					user.setAdministrator(result.getBoolean(3));
				}
				return user;
			}
			catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
	}

	@Override
	public void addUser(User user) {
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				stmt.executeQuery("INSERT INTO USERS VALUES (" + user.getId() + "," + user.getPassword() + ", false)");
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateUser(User user) {
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				stmt.executeQuery("UPDATE USERS SET PASSWORD = "+ user.getPassword() + " WHERE ID = " + user.getId());
			}
			catch( SQLException e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteUser(User user) {
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				stmt.executeQuery("DELETE FROM USERS WHERE Id = " + user.getId());
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}

	}

}
