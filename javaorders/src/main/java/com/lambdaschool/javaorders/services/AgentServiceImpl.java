package com.lambdaschool.javaorders.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.repositories.AgentRepository;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentRepository agentrepos;

	@Override
	public Agent findAgentById(long id) {
		Agent foundAgent = agentrepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Agent not found " + id));

		return foundAgent;
	}

}
