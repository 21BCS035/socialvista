package com.socialvista.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.socialvista.socialmedia.service.ChatService;

@RestController
public class ChatController {
    private ChatService chatService;
    
}
