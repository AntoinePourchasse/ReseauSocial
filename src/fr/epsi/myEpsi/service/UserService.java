package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.UserDao;

public class UserService implements IUserService {

	private UserDao userDao;
	
	public UserService(){
		userDao = new UserDao();
	}
	
	@Override
	public List<User> getListOfUsers() {
		// TODO Auto-generated method stub
		return userDao.getListOfUsers();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}

}
