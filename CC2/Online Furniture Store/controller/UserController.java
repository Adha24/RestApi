package com.example.demo.projectfurniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.projectfurniture.model.User;
import com.example.demo.projectfurniture.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService useService;
    @PostMapping("/api/users/add")
    public User addUsers(@RequestBody User user)
    {
        return useService.adduser(user);
    }
    @GetMapping("/api/users/get")
    public List<User>getUsers()
    {
        return useService.getUser();
    }
    @GetMapping("/api/users/sortby/{field}")
    public List<User>SortUsers(@PathVariable String field)
    {
       return useService.sortUsers(field);
    }
    @GetMapping("/api/furnitures/pageusers/{pageNo}/{pageSize}")
    public List<User> PageUsers(@PathVariable int pageNo,@PathVariable int pageSize)
    {
        return useService.PageUsers(pageNo, pageSize);
    }
    @GetMapping("/api/furnitures/pageusersandsort/{pageNo}/{pageSize}/{field}")
    public List<User> PageUsers(@PathVariable int pageNo,@PathVariable int pageSize,@PathVariable String field)
    {
        return useService.pageUsersAndSorting(pageNo,pageSize,field);
    }
    @GetMapping("/api/users/findbyusername/{username}")
    public List<User> getUserByName(@PathVariable String username)
    {
        return useService.getUserByName(username);
    }
    
}
