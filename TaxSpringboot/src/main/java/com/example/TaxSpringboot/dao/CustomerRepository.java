package com.example.TaxSpringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TaxSpringboot.entity.Customer;
import com.example.TaxSpringboot.entity.TaxForm;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
	@Query("SELECT c FROM Customer c where c.pan=:pan")
	Customer getCustByPan(String pan);
	
	

}
