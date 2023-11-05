
package com.fil.easemystay.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.easemystay.dao.AdminDao;
import com.fil.easemystay.entities.Admin;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao aDao;
	
	public AdminServiceImpl(AdminDao aDao) {
		super();
		this.aDao = aDao;
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		Admin authenticatedUser = aDao.findByEmailAdmin(email);

		if (authenticatedUser != null && authenticatedUser.getPassword().equals(password)) {
			return authenticatedUser;
		} else {

			return null;
		}
	}

}