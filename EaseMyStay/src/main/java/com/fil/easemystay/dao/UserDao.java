package com.fil.easemystay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT u FROM User u WHERE u.user_email = :inputname")
	User findByEmail(@Param("inputname") String username);


}
