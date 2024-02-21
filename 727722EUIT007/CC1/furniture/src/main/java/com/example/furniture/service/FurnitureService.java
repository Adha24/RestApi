package com.example.furniture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.furniture.model.Furniture;
import com.example.furniture.repository.FurnitureRepo;

@Service
public class FurnitureService {
    @Autowired
    FurnitureRepo furnitureRepo;
   
    
    public Furniture addProducts(Furniture furniture)
    {
        return furnitureRepo.save(furniture);
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
    
}
