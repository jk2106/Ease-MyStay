package com.fil.easemystay.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.Payment;

@Repository
public interface PaymentDao  extends JpaRepository<Payment, Integer>{

}