package com.example.demo.projectfurniture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.projectfurniture.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> 
{
     
    @Query(value="select * from users u join furnitures f on u.userid=f.use_id where u.username=?1 ",nativeQuery=true)
    List<User>getUserByName(String username);
}
