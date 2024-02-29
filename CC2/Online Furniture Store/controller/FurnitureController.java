package com.example.demo.projectfurniture.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.projectfurniture.model.Furniture;
import com.example.demo.projectfurniture.model.User;
import com.example.demo.projectfurniture.service.FurnitureService;

@RestController
public class FurnitureController {
    @Autowired
    FurnitureService furnitureService;
    // @PostMapping("/api/furnitures/postproducts")
    public ResponseEntity<Furniture> addProducts(@RequestBody Furniture furniture)
    {
        return new ResponseEntity<>(furnitureService.addProducts(furniture),HttpStatus.CREATED);
    }
    // @PostMapping("/api/products/postbysql")
    // public Furniture addFurnitures(@RequestBody  Furniture furniture)
    // {
    //     return furnitureService.addFurnitues(furniture);
    // }
    @PostMapping("/api/furnitures/postproductslist")
    public ResponseEntity<List<Furniture>> addProducts(@RequestBody List<Furniture> furniture)
    {
        return new ResponseEntity<>(furnitureService.addAll(furniture),HttpStatus.CREATED);
    }
    // @PostMapping("/api/furnitures/postusers")
    // public User addUsers(@RequestBody User u)
    // {
    //     return furnitureService.adduser(u);
    // }
    // @GetMapping("/api/furnitures/getusers")
    // public List<User> getUsers()
    // {
    //     return furnitureService.getUser();
    // }
    @GetMapping("/api/furnitures/getproducts")
    public ResponseEntity<List<Furniture>> getProducts()
    {
        return new ResponseEntity<>(furnitureService.getProducts(),HttpStatus.CREATED);
    }
    @GetMapping("/api/furnitures/getproducts/{productId}")
    public ResponseEntity<Optional<Furniture>> getProductById(@PathVariable Long productId)
    {
        return new ResponseEntity<>(furnitureService.getProductById(productId),HttpStatus.CREATED);
    }
    @PutMapping("/api/furnitures/editproducts/{productId}")
    public ResponseEntity<Furniture> editProducts(@PathVariable Long productId,@RequestBody Furniture furniture)
    {
        return new ResponseEntity<>(furnitureService.editFurnitures(productId,furniture),HttpStatus.CREATED);
    }
    @DeleteMapping("/api/furnitures/deleteproducts/{productId}")
    public ResponseEntity<String> deleteFurniture(@PathVariable Long productId)
    {
        return new ResponseEntity<>(furnitureService.deleteFurnitures(productId),HttpStatus.CREATED);
    }
    @GetMapping("/api/furnitures/getproductbyname")
    public List<Furniture> getFurnitureByName(@RequestParam(name="productName") String productName)
    {
        return furnitureService.getFurnitureByName(productName);
    }
    @GetMapping("/api/furnitures/sortfurnitures/{field}")
    public List<Furniture> SortFurnituresByField(@PathVariable String field)
    {
        return furnitureService.SortFurnituresByField(field);
    }
    
    
    }
 
