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
import fr.epsi.myEpsi.service.UserService;

public class MessageDao implements IMessageDao {

	static Connection con = ConnectionTool.getConnection();
	@Override
	public List<Message> getListOfMessages(User user) {
		UserService US = new UserService();
		List<Message> messages = new ArrayList<>();
		if(con != null){
			try {
				Statement stmt = con.createStatement();
				ResultSet result=stmt.executeQuery("SELECT * FROM MESSAGES WHERE USER_ID = '"+ user.getId() + "' OR STATUS = 0");
				while (result.next()){
					Message message = new Message();
					message.setId(Long.valueOf(result.getInt(1)));
					message.setTitle(result.getString(2));
					message.setContent(result.getString(3));
					message.setAuthor(US.getUserById(result.getString(4)));
					message.setCreationDate(result.getTimestamp(5));
					message.setUpdateDate(result.getTimestamp(6));
					message.setStatus(Status.values()[result.getInt(7)]);
					messages.add(message);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return messages;
		}
		else
			return null;
		
	}

	@Override
	public Message getMessage(Long id) {
		Message message = new Message();
		if(con != null){
			try{
			Statement stmt = con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM MESSAGES WHERE ID=" + id);
			while(result.next()){
				message.setId(Long.valueOf(result.getInt(1)));
				message.setTitle(result.getString(2));
				message.setContent(result.getString(3));
				//message.setAuthor(result.getString(4));
				message.setCreationDate(result.getTimestamp(5));
				message.setUpdateDate(result.getTimestamp(6));
				message.setStatus(Status.values()[result.getInt(7)]);
			}
			}
			catch (SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		
		return null;
	}

	@Override
	public void addMessage(Message message) {
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				stmt.executeQuery("INSERT INTO MESSAGES VALUES (" +message.getId() + ",'"+ message.getTitle() + "','" + message.getContent() + "','" + message.getAuthor().getId() + "','" + message.getCreationDate() + "','" + message.getCreationDate() + "'," + message.getStatus().ordinal() + ")" );
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		if(con != null){
			try{
				Statement stmt = con.createStatement();
			stmt.executeQuery("UPDATE MESSAGES SET TITLE = " + message.getTitle() + ", CONTENT = " + message.getContent() + ", UPDATE_DATE = " + message.getUpdateDate() + ", STATUS = "  + status );
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteMessage(Message message) {
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				stmt.executeQuery("DELETE FROM MESSAGES WHERE ID = " + message.getId());
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}

	}
	
	public static int nbrMessage(){
		int nbrMessage = 0;
		if(con != null){
			try {
				Statement stmt = con.createStatement();
				ResultSet result=stmt.executeQuery("SELECT COUNT(*) FROM MESSAGES");
				while (result.next()){
					nbrMessage = result.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return nbrMessage;
			}
			return nbrMessage;
		}
		else
			return nbrMessage;
		
	}
	
	public static int nextId(){
		int id = 0;
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				ResultSet result=stmt.executeQuery("SELECT max(ID) FROM MESSAGES");
				while(result.next())
					id = result.getInt(1);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return id+1;
		
	}

}
