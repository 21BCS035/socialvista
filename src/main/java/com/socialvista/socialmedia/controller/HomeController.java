package com.socialvista.socialmedia.controller;

import java.util.List;

// import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundException;
import com.socialvista.socialmedia.models.User;
import com.socialvista.socialmedia.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@AllArgsConstructor
@RestController
@RequestMapping("/api/users")

public class HomeController {
    @Autowired
    UserRepository userRepository;
     
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {

        User newUser = new User();
        
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        User savedUser = userRepository.save(newUser);

        return savedUser;
    }

    @GetMapping("/getAllUsers")
    public List<User>getUsers() {
       List<User>users = userRepository.findAll();

       return users;
    }


    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {

        User user = userRepository.findById(id)
         .orElseThrow(()->
         new ResourceNotFoundException("User is not found with the id : " + id)
         );

        return user;
    }
    
    
    @PutMapping("/updateUser/{id}")
    public User updatUser(@PathVariable Integer id, @RequestBody User Updateduser) {
       
           User user = userRepository.findById(id)
           .orElseThrow(()->
           new ResourceNotFoundException("User is not found with the id : " + id)
         );
         
         if(Updateduser.getFirstname() != null){
            user.setFirstname(Updateduser.getFirstname());
         }
         if(Updateduser.getLastname() != null){
            user.setLastname(Updateduser.getLastname());
         }
         if(Updateduser.getEmail() != null){
            user.setEmail(Updateduser.getEmail());
         }
         if(Updateduser.getPassword() != null){
            user.setPassword(Updateduser.getPassword());
         }
         
         User savedUser = userRepository.save(user);
        
        return savedUser;
    }


    @DeleteMapping("deleteUser/{id}")
    public String deleteUser( @PathVariable("id") Integer id){
        User user = userRepository.findById(id)
        .orElseThrow(()->
         new ResourceNotFoundException("User is not found with the id : " + id)
         );

         userRepository.deleteById(id);

         return "User has been deleted successfully";
    }


}
