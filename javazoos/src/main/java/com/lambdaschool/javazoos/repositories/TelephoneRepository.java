package com.lambdaschool.javazoos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.javazoos.models.Telephone;

public interface TelephoneRepository extends CrudRepository<Telephone, Long> {

}
