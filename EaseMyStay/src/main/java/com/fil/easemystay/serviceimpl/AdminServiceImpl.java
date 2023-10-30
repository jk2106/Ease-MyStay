package com.fil.easemystay.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.easemystay.dao.AdminDao;
import com.fil.easemystay.entities.Admin;
import com.fil.easemystay.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao aDao;
	
	public AdminServiceImpl(AdminDao aDao) {
		super();
		this.aDao = aDao;
	}
	
	@Override
	public Admin registerAdmin(Admin admin) throws Exception{
		Optional<Admin> adminExist = aDao.findByEmail(admin.getEmail());

		if (adminExist.isPresent()) {
			throw new Exception("Admin already registered with this email!");
		}

		String hashedPassword =admin.getPassword();
		admin.setPassword(hashedPassword);
		admin.setRole(com.fil.easemystay.enums.Role.ROLE_ADMIN);

		return aDao.save(admin);
	}

}
