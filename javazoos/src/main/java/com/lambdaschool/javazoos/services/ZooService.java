package com.lambdaschool.javazoos.services;

import java.util.List;

import com.lambdaschool.javazoos.models.Zoo;

public interface ZooService {
	public List<Zoo> findAllZoos();
	
	public Zoo findZooById(long id);
	
	public Zoo saveZoo(Zoo zoo);
	
	public Zoo updateZoo(Zoo zoo, long id);
	
	public void deleteZooById(long id);
}
