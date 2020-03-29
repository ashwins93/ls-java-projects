package com.lambdaschool.crudyrestauarants.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long restaurantid;

	@Column(unique = true, nullable = false)
	private String name;
	private String address;
	private String city;
	private String state;
	private String telephone;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("restaurant")
	private List<Menu> menus = new ArrayList<>();

	public Restaurant() {
	}

	public Restaurant(String name, String address, String city, String state, String telephone) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.telephone = telephone;
	}

	public long getRestaurantid() {
		return this.restaurantid;
	}

	public void setRestaurantid(long restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}