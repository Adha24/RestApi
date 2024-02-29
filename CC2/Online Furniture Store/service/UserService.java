package com.example.demo.projectfurniture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.projectfurniture.model.User;
import com.example.demo.projectfurniture.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo useRepo;
    public User adduser(User u)
    {
        return useRepo.save(u);
    }
     public List<User> getUser()
    {
        return useRepo.findAll();
    }
    public List<User> sortUsers(String field)
    {
        return useRepo.findAll(Sort.by(field));
    }
    public List<User>PageUsers(int pageNo,int pageSize)
    {
        return useRepo.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }
    public List<User> getUserByName(String username)
    {
        return useRepo.getUserByName(username);
    }
    public List<User> pageUsersAndSorting(int pageNo, int pageSize, String field) {
        // Create a PageRequest with the specified page number, page size, and sorting by the given field
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(field));
    
        // Retrieve the page of users from the repository using the PageRequest
        Page<User> page = useRepo.findAll(pageRequest);
    
        // Extract and return the content (list of users) from the page
        return page.getContent();
    }
}
