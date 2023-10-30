package com.fil.easemystay.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fil.easemystay.entities.Admin;
	
	public interface AdminDao extends JpaRepository<Admin,Integer>{
		@Query("SELECT u FROM Admin u WHERE u.admin_email = :admin_email")
		Optional<Admin> findByEmail(@Param("admin_email") String admin_email);
	}
