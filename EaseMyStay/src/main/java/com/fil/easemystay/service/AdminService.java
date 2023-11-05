package com.fil.easemystay.service;

import com.fil.easemystay.entities.Admin;
import com.fil.easemystay.entities.User;

public interface AdminService {

	public Admin loginAdmin(String email, String password);

}