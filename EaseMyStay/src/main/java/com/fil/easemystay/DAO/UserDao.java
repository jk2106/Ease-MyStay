package com.fil.easemystay.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.User;

@Repository
public interface UserDao  extends JpaRepository<User, Integer>{

}