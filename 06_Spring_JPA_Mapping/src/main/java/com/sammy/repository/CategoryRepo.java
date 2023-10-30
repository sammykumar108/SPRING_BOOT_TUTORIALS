package com.sammy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sammy.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
