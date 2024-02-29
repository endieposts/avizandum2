package com.endie.avizandum.controller;

import com.endie.avizandum.service.SqsMessageSender;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqsMessageController {
    private final SqsMessageSender messageSender;
    public SqsMessageController(SqsMessageSender messageSender) {
        this.messageSender = messageSender;
    }
    @PostMapping("/sendmessage")
    public void sendMessage(Authentication authentication, @RequestBody String message) {
        messageSender.sendMessage(message);
    }

}
