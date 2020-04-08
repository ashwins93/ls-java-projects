package com.lambdaschool.javazoos.repositories;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lambdaschool.javazoos.models.Zoo;

public interface ZooRepository extends CrudRepository<Zoo, Long> {
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM zooanimals \n" + 
			"WHERE zooid = :zooid AND animalid = :animalid", nativeQuery = true)
	public void deleteZooAnimal(long zooid, long animalid);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO zooanimals(zooid, animalid, incomingzoo, createdby, createddate, lastmodifiedby, lastmodifieddate) VALUES (:zooid, :animalid, :incomingzoo, :uname, CURRENT_TIMESTAMP, :uname, CURRENT_TIMESTAMP)",
		nativeQuery = true)
	public void addZooAnimal(
			long zooid,
			long animalid,
			String incomingzoo,
			String uname);
	

}
