package com.example.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.furniture.model.Furniture;

import java.util.List;


@SuppressWarnings("unused")
public interface FurnitureRepo extends JpaRepository<Furniture,Long>,PagingAndSortingRepository<Furniture,Long>{

    List<Furniture>findByProductName(String productName);

    
}
