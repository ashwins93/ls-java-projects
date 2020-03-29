package com.lambdaschool.crudyrestauarants.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.crudyrestauarants.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
