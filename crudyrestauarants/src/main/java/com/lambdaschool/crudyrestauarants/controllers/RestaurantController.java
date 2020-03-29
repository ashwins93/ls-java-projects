package com.lambdaschool.crudyrestauarants.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambdaschool.crudyrestauarants.models.Restaurant;
import com.lambdaschool.crudyrestauarants.services.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantService service;

	// GET /api/restaurants
	@GetMapping(value = "", produces = { "application/json" })
	public ResponseEntity<?> listAllRestaurants() {
		List<Restaurant> myList = service.findall();

		return new ResponseEntity<>(myList, HttpStatus.OK);
	}

	// GET /api/restaurants/{id}
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public ResponseEntity<?> getRestaurantById(@PathVariable long id) {
		Restaurant myRestaurant = service.findById(id);

		return new ResponseEntity<>(myRestaurant, HttpStatus.OK);
	}

	// POST /api/restaurants/
	@PostMapping(value = "", consumes = { "application/json" })
	public ResponseEntity<?> addNewRestaurant(@Valid @RequestBody Restaurant newRestaurant) {
		service.save(newRestaurant);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// PUT /api/restaurants/{id}
	@PutMapping(value = "/{id}", consumes = { "application/json" })
	public ResponseEntity<?> updateRestaurant(@Valid @RequestBody Restaurant restaurant,
											  @PathVariable long id) {
		service.update(restaurant, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// DELETE /api/restaurants/{id}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteRestaurantById(@PathVariable long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
