package com.lambdaschool.crudyrestauarants.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "menus")
public class Menu {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long menuid;

  @Column(nullable = false)
  private String dish;
  private double price;

  @ManyToOne
  @JoinColumn(name = "restaurantid", nullable = false)
  @JsonIgnoreProperties("menus")
  private Restaurant restaurant;

  public Menu() {
  }

  public Menu(String dish, double price, Restaurant restaurant) {
    this.dish = dish;
    this.price = price;
    this.restaurant = restaurant;
  }

  public long getMenuid() {
    return this.menuid;
  }

  public void setMenuid(long menuid) {
    this.menuid = menuid;
  }

  public String getDish() {
    return this.dish;
  }

  public void setDish(String dish) {
    this.dish = dish;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Restaurant getRestaurant() {
    return this.restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

}