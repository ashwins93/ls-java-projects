package com.lambdaschool.javazoos.services;

import java.util.List;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.views.AnimalPopulationByZoo;

public interface AnimalService {
	public List<AnimalPopulationByZoo> findAnimalPopulation();
	
	public Animal findAnimalById(long id);
}
