package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.MessageDao;
import fr.epsi.myEpsi.dao.UserDao;

public class MessageService implements IMessageService {

	private MessageDao messageDao;
	
	public MessageService(){
		messageDao = new MessageDao();
	}
	
	@Override
	public List<Message> getListOfMessages(User user) {
		// TODO Auto-generated method stub
		return messageDao.getListOfMessages(user);
	}

	@Override
	public Message getMessage(Long id) {
		// TODO Auto-generated method stub
		return messageDao.getMessage(id);
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		messageDao.addMessage(message);
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		// TODO Auto-generated method stub
		messageDao.updateMessageStatus(message, status);
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		messageDao.deleteMessage(message);
	}

}
