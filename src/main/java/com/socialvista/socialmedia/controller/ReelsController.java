package com.socialvista.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.socialvista.socialmedia.models.Reels;
import com.socialvista.socialmedia.models.User;
import com.socialvista.socialmedia.service.ReelsService;
import com.socialvista.socialmedia.service.UserService;

@RestController
public class ReelsController {

    @Autowired
    private ReelsService reelsService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/reels/createreel")
    public Reels createReels(@RequestBody Reels reel,@RequestHeader("Authorization") String jwt){

        User user = userService.findUserByJwt(jwt); 
            Reels createReel = reelsService.createReel(reel, user);       
        return createReel;
    }
    
}
