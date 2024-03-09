package com.socialvista.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.socialvista.socialmedia.service.PostService;

import com.socialvista.socialmedia.models.UserPost;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController

@RequestMapping("/api/posts")
public class PostController {
    @Autowired
     PostService postService;

     @PostMapping("/createPost/{userId}")
    public ResponseEntity<UserPost> createNewPost(@RequestBody UserPost post,@PathVariable Integer userId){
        UserPost createdPost = postService.createNewPost(post,userId);

        return new ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
    }

     
}
