package com.lambdaschool.crudyrestauarants.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambdaschool.crudyrestauarants.models.Menu;
import com.lambdaschool.crudyrestauarants.models.Restaurant;
import com.lambdaschool.crudyrestauarants.repositories.RestaurantRepository;

@Transactional
@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantRepository restrepos;

	@Override
	public List<Restaurant> findall() {
		List<Restaurant> rtnList = new ArrayList<Restaurant>();
		restrepos.findAll().iterator().forEachRemaining(rtnList::add);

		return rtnList;
	}

	@Override
	public Restaurant findById(long id) {
		// TODO Auto-generated method stub
		return restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found " + id));
	}

	@Transactional
	@Override
	public Restaurant save(Restaurant restaurant) {
		Restaurant newRestaurant = new Restaurant();

		newRestaurant.setName(restaurant.getName());
		newRestaurant.setAddress(restaurant.getAddress());
		newRestaurant.setCity(restaurant.getCity());
		newRestaurant.setState(restaurant.getState());
		newRestaurant.setTelephone(restaurant.getTelephone());

		for (Menu m : restaurant.getMenus()) {
			newRestaurant.getMenus().add(new Menu(m.getDish(), m.getPrice(), newRestaurant));
		}

		return restrepos.save(newRestaurant);
	}

	@Override
	public Restaurant update(Restaurant restaurant, long id) {

		return restrepos.save(restaurant);
	}

	@Override
	public void delete(long id) {
		restrepos.deleteById(id);
	}

}
