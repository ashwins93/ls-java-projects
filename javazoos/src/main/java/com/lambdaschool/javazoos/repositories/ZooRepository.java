package com.lambdaschool.javazoos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.javazoos.models.Zoo;

public interface ZooRepository extends CrudRepository<Zoo, Long> {

}
