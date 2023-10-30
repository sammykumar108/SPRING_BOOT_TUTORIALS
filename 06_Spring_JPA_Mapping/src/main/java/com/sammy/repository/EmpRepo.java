package com.sammy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sammy.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer>{

}
