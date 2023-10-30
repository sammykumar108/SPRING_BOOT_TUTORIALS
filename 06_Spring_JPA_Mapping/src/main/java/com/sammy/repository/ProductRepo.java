package com.sammy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sammy.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
