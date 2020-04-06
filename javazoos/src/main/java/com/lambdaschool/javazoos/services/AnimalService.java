package com.lambdaschool.javazoos.services;

import java.util.List;

import com.lambdaschool.javazoos.views.AnimalPopulationByZoo;

public interface AnimalService {
	public List<AnimalPopulationByZoo> findAnimalPopulation();
}
