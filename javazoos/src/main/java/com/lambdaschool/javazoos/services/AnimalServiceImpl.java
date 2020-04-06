package com.lambdaschool.javazoos.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.repositories.AnimalRepository;
import com.lambdaschool.javazoos.views.AnimalPopulationByZoo;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService {
	@Autowired
	private AnimalRepository animalRepo;

	@Override
	public List<AnimalPopulationByZoo> findAnimalPopulation() {
		return animalRepo.findAnimalPopulation();
	}

	@Override
	public Animal findAnimalById(long id) {
		Animal animal = animalRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid animal id " + id));
		
		return animal;
	}

}
