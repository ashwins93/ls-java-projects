package com.lambdaschool.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.javaorders.models.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long> {

}
