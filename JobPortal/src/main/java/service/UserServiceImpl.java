package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import model.Login;
import model.Skill;
import model.User;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	public void register(User user) {
		userDao.register(user);
	}
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
	@Override
	public User addskill(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
