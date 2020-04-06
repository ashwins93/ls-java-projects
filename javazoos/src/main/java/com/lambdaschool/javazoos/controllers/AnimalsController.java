package com.lambdaschool.javazoos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambdaschool.javazoos.services.AnimalService;
import com.lambdaschool.javazoos.views.AnimalPopulationByZoo;

@RestController
@RequestMapping("/animals")
public class AnimalsController {
	@Autowired
	private AnimalService animalService;
	
	@GetMapping(value = "/count", produces = {"application/json"})
	public ResponseEntity<?> getAllAnimalZooCount() {
		List<AnimalPopulationByZoo> animals = animalService.findAnimalPopulation();
		
		return new ResponseEntity<>(animals, HttpStatus.OK);
	}
}
