package com.example.demo.projectfurniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.projectfurniture.model.Furniture;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("unused")
public interface FurnitureRepo extends JpaRepository<Furniture,Long>,PagingAndSortingRepository<Furniture,Long>{

    List<Furniture>findByProductName(String productName);
    // @Query("select u from Furniture u where u.productId = ?1")
    // Optional<Furniture>findById(long productId);
    // @Query("select u from Furniture u where u.productId = :id")
    // Optional<Furniture>findById(@Param("id") long productId);

    // @Query("insert into Users(productName,price,description,quantity) value(?1,?2,?3,?4)")
    // Furniture addFurnitures(String productName,double d,String description,int quantity);
    
    // @Query("insert into Users(productName,price,description,quantity) value(:name,:price,:description,:quantity)")
    // Furniture addFurnitues(@Param("name")String productName,@Param("price")double d,@Param("description")String description,@Param("quantity") int quantity);
    
}
