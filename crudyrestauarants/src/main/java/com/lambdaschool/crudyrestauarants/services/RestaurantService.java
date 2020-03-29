package com.lambdaschool.crudyrestauarants.services;

import java.util.List;

import com.lambdaschool.crudyrestauarants.models.Restaurant;

public interface RestaurantService {
	List<Restaurant> findall();
	
	Restaurant findById(long id);
	
	Restaurant save(Restaurant restaurant);
	
	Restaurant update(Restaurant restuarant, long id);
	
	void delete(long id);
	
}

