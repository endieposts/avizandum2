package com.endie.avizandum.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.endie.avizandum.domain.Terrain;
import com.endie.avizandum.repository.TerrainRepository;

@RestController
public class TerrainController {

	@Autowired
	private TerrainRepository repository;
	
	@RequestMapping("/terrains")
	public Iterable<Terrain> getTerrains() {
		return repository.findAll();
	}
	
	@RequestMapping("/terrains/{id}")
	public Optional<Terrain> getTerrain(@PathVariable long id) {
		return repository.findById(id);
	}
}
