package com.endie.avizandum.controller;

import com.endie.avizandum.repository.PlayerTurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerTurnController {

    @Autowired
    PlayerTurnRepository repository;

    @RequestMapping("/playerTurn")
    public Iterable<com.endie.avizandum.domain.PlayerTurn> getPlayerTurns() {
        return repository.findAll();
    }
}