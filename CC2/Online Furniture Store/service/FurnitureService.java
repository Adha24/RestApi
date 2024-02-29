package com.example.demo.projectfurniture.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.projectfurniture.model.Furniture;
import com.example.demo.projectfurniture.model.User;
import com.example.demo.projectfurniture.repository.FurnitureRepo;
import com.example.demo.projectfurniture.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
// "if there is error it simply rollback to previous state"
public class FurnitureService {
    @Autowired
    FurnitureRepo furnitureRepo;
    @Autowired
    UserRepo useRepo;
    
    public Furniture addProducts(Furniture furniture)
    {
        return furnitureRepo.save(furniture);
    }
    // public Furniture addFurnitues(Furniture furniture)
    // {
    //     return furnitureRepo.addFurnitures(furniture.getProductName(), furniture.getPrice(), furniture.getDescription(), furniture.getQuantity());
    // }
    public List<Furniture> addAll(List<Furniture> furniture)
    {
        return furnitureRepo.saveAll(furniture);
    }
    
    public List<Furniture> getFurnitureByName(String productName)
    {
        return furnitureRepo.findByProductName(productName);
    }
    
    public List<Furniture> getProducts()
    {
        return furnitureRepo.findAll();
    }
   
    public Optional<Furniture> getProductById(Long id)
    {
        return furnitureRepo.findById(id);
    }
    public Furniture editFurnitures(Long id,Furniture furniture)
    {
        Furniture f=furnitureRepo.findById(id).orElse(null);
        if(f!=null)
        {
            f.setDescription(furniture.getDescription());
            f.setPrice(furniture.getPrice());
            f.setProductName(furniture.getProductName());
            f.setQuantity(furniture.getQuantity());
            return furnitureRepo.saveAndFlush(f);
        }
        else
        return null;
    }
    public String deleteFurnitures(Long id)
    {
        furnitureRepo.deleteById(id);
        return("Deleted Succesfully");
    }
    public List<Furniture> SortFurnituresByField(String field)
    {
        return furnitureRepo.findAll(Sort.by(field));
    }
    
    
    
}
