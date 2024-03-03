package com.endie.avizandum.controller;

import com.endie.avizandum.repository.PlayerTurnRepository;
import com.endie.avizandum.service.SqsMessageSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.endie.avizandum.domain.PlayerTurn;

@RestController
public class PlayerTurnController {

    @Autowired
    PlayerTurnRepository repository;

    @Autowired
    private SqsMessageSender sqsMessageSender;

    @RequestMapping(value="/playerTurn")
    public Iterable<com.endie.avizandum.domain.PlayerTurn> getPlayerTurns() {
        return repository.findAll();
    }

    @RequestMapping(value="/playerTurn/{id}")
    public com.endie.avizandum.domain.PlayerTurn getPlayerTurnById(long id) {
        return repository.findById(id).get();
    }

    //Receive a post request to add a player turn
    @RequestMapping(value="/playerTurn", method= RequestMethod.POST)
    public void addPlayerTurn( PlayerTurn playerTurn) {
        String message = "Player turn failed to serialise";

        repository.save(playerTurn);

        //serialise the player turn to a string and send it to the message queue using Gson

        ObjectMapper mapper = new ObjectMapper();
        try {
            message = mapper.writeValueAsString(playerTurn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sqsMessageSender.sendMessage(message);
    }
}