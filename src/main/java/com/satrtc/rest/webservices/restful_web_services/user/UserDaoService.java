package com.satrtc.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static int userCount=0;
	static List<User> userList=new ArrayList<User>();
	static {
		userList.add(new User(++userCount,"jacob",LocalDate.now()));
		userList.add(new User(++userCount,"raju",LocalDate.now()));
		userList.add(new User(++userCount,"matcha",LocalDate.now()));
		userList.add(new User(++userCount,"rishi",LocalDate.now()));
	}
	
	List<User> getAllUsers()
	{
		return userList;
	}

	public User getUserDetail(int id) {
		
		for (User user : userList) {
			if(user.getId()==id)
			return user;
		}
		return null;
		
	}

	public void addUser(User user) {
		user.setId(++userCount);
		userList.add(user);
	}
}
