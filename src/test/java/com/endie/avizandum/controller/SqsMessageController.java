package com.endie.avizandum.controller;

import com.endie.avizandum.service.SqsMessageSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class SqsMessageController {
    @RestController
    public class MessageController {
        private final SqsMessageSender messageSender;
        public MessageController(SqsMessageSender messageSender) {
            this.messageSender = messageSender;
        }
        @PostMapping("/sendmessage")
        public void sendMessage(@RequestBody String message) {
            messageSender.sendMessage(message);
        }
    }
}
