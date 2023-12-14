package com.endie.avizandum.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.endie.avizandum.domain.District;
import com.endie.avizandum.repository.DistrictRepository;

@RestController
public class DistrictController {

	final
	DistrictRepository repository;

	public DistrictController(DistrictRepository repository) {
		this.repository = repository;
	}

	@RequestMapping("/districts")
	public Iterable<District> getDistricts(){
		return repository.findAll();
	}
	
	@RequestMapping("districts/{id}")
	public Optional<District> getDistrictById(@PathVariable long id){
		return repository.findById(id);
	}
	
}
