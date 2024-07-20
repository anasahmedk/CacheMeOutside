package com.dvt.hackathon.demo.controller;

import java.io.IOException;

import com.dvt.hackathon.demo.model.Chat;
import com.dvt.hackathon.demo.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/{criteria}")
    public String rewardOrCritiqueMessage(@PathVariable String criteria) {
        try {
            return chatGPTService.chatGPTWithCriteria(criteria);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @PostMapping
    public String chat(@RequestBody Chat chat) {
        try {
            return chatGPTService.chatGPT(chat.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
