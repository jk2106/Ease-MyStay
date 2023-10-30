package com.fil.easemystay.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.easemystay.dao.UserDao;
import com.fil.easemystay.entities.User;
import com.fil.easemystay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public User createUser(User user) {
		User createdUser = userdao.save(user);
		return createdUser;
	}

	@Override
	public User loginUser(String email, String password) {
		User authenticatedUser = userdao.findByEmail(email);

		if (authenticatedUser != null && authenticatedUser.getUser_password().equals(password)) {
			return authenticatedUser;
		} else {

			return null;
		}
	}
	
	@Override
	public User updateUser(User user) {
	    User existingUser = userdao.findByEmail(user.getUser_email());
	    
	    System.out.println(existingUser);

	    if (existingUser != null) {
	        existingUser.setUser_name(user.getUser_name());
	        existingUser.setUser_dob(user.getUser_dob());
	        existingUser.setUser_contact(user.getUser_contact());
	        existingUser.setUser_password(user.getUser_password());
	        existingUser.setUser_email(user.getUser_email());

	        User updatedUser = userdao.save(existingUser);

	        return updatedUser;
	    } else {
	        return null;
	    }
	}
	
	
	@Override
	public boolean deleteUser(User user) {
	    User existingUser = userdao.findByEmail(user.getUser_email());

	    if (existingUser != null) {
	        userdao.delete(existingUser);
	        return true;
	    } else {
	        return false;
	    }
	}

	
	
	
	
	}
