package com.endie.avizandum.controller;

import com.endie.avizandum.domain.District;
import com.endie.avizandum.domain.Player;
import com.endie.avizandum.repository.PlayerRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlayerController {

    final PlayerRepository repository;


    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/players")
    public Iterable getPlayers(){
        return repository.findAll();
    }

    @RequestMapping("/players/{id}")
    public Optional<Player> getPlayerById(@PathVariable long id){
        return repository.findById(id);
    }
}
