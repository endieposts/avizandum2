package com.endie.avizandum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurnComponentController {

    @Autowired
    private TurnComponentRepository repository;

}
