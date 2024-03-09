package com.socialvista.socialmedia.controller;

import java.util.List;

// import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundException;
import com.socialvista.socialmedia.models.User;
import com.socialvista.socialmedia.repository.UserRepository;
import com.socialvista.socialmedia.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@AllArgsConstructor
@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
     
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {

        User savedUser = userService.createUser(user);

        return savedUser;
    }

    @GetMapping("/getAllUsers")
    public List<User>getUsers() {
       List<User>users = userRepository.findAll();

       return users;
    }


    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
         
      User user = userService.findUserById(id);

      return user;
      
    }
    
    
    @PutMapping("/updateUser/{id}")
    public User updatUser(@PathVariable Integer id, @RequestBody User Updateduser) {
       
         User user = userService.updateUser(Updateduser,id);

         return user;
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


    @PutMapping("followusers/{id1}/{id2}")
    public User folloUserHandler(@PathVariable Integer id1, @PathVariable Integer id2) {
       
         User user = userService.followUser(id1, id2);

        return user;
    }

    @GetMapping("searchUser")
    public List<User> searchUser(@RequestParam("query") String query) {
       List<User> users = userService.searchUser(query);
       return users;
    }
    

}
