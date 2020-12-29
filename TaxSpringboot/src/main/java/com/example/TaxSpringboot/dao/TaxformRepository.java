package com.example.TaxSpringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaxSpringboot.entity.TaxForm;


@Repository
public interface TaxformRepository extends JpaRepository<TaxForm, Long>{

}
