package com.lambdaschool.crudyrestauarants.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.crudyrestauarants.models.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {

}