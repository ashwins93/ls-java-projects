package com.lambdaschool.javaorders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.services.AgentService;

@RestController
@RequestMapping("/api/agents")
public class AgentsController {
	@Autowired
	private AgentService service;
	
	@GetMapping(value = "/{id}", produces = {"application/json"})
	public ResponseEntity<?> getAgentById(@PathVariable long id) {
		Agent foundAgent = service.findAgentById(id);
		
		return new ResponseEntity<>(foundAgent, HttpStatus.OK);
	}

}
