package com.lambdaschool.javazoos.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.services.ZooService;

@RestController
@RequestMapping("/zoos")
public class ZoosController {
	@Autowired
	private ZooService zooService;

	@GetMapping(value = "/all", produces = { "application/json" })
	public ResponseEntity<?> getAllZoos() {
		List<Zoo> zoos = zooService.findAllZoos();

		return new ResponseEntity<>(zoos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { "application/json" })
	public ResponseEntity<?> getZooById(@PathVariable long id) {
		Zoo zoo = zooService.findZooById(id);

		return new ResponseEntity<>(zoo, HttpStatus.OK);
	}

	@PostMapping(value = "", consumes = { "application/json" })
	public ResponseEntity<?> createNewZoo(@Valid @RequestBody Zoo zoo) {
		Zoo newZoo = zooService.saveZoo(zoo);

		HttpHeaders responseHeaders = new HttpHeaders();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newZoo.getZooid())
				.toUri();
		responseHeaders.setLocation(uri);

		return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteZoo(@PathVariable long id) {
		zooService.deleteZooById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateZoo(@RequestBody Zoo zoo, @PathVariable long id) {
		zooService.updateZoo(zoo, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<?> updateZooPartial(@RequestBody Zoo zoo, @PathVariable long id) {
		zooService.updateZoo(zoo, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/namelike/{name}")
	public ResponseEntity<?> searchZooByName(@PathVariable String name) {
		List<Zoo> results = zooService.searchZooByName(name);
		
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
}
