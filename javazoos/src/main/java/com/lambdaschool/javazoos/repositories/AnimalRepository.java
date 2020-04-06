package com.lambdaschool.javazoos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.views.AnimalPopulationByZoo;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
	@Query(value = "SELECT a.animalid, a.animaltype, count(za.zooid) as count\n" + 
			"FROM animals a\n" + 
			"LEFT JOIN zooanimals za ON a.animalid = za.animalid\n" + 
			"GROUP BY a.animalid, a.animaltype",
			nativeQuery = true)
	public List<AnimalPopulationByZoo> findAnimalPopulation();
}
