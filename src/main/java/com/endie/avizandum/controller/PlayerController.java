package com.endie.avizandum.controller;

import com.endie.avizandum.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.endie.avizandum.repository.PlayerRepository;

import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository repository;

    @RequestMapping("/players")
    public Iterable<com.endie.avizandum.domain.Player> getPlayers(){
        return repository.findAll();
    }

    @RequestMapping("/players/{id}")
    public Optional<Player> getPlayerById(@PathVariable long id){
        return repository.findById(id);
    }
}
