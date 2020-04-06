package com.lambdaschool.javazoos.models;

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
@Table(name = "zoos")
public class Zoo extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long zooid;
	
	@Column(nullable = false)
	private String zooname;

	@OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "zoo")
	private List<Telephone> telephones;
	
	@OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "zoo")
	private List<ZooAnimal> animals;

	public Zoo() {
		super();
	}

	public Zoo(String zooname, List<Telephone> telephones, List<ZooAnimal> animals) {
		super();
		this.zooname = zooname;
		this.telephones = telephones;
		this.animals = animals;
	}

	public long getZooid() {
		return zooid;
	}

	public void setZooid(long zooid) {
		this.zooid = zooid;
	}

	public String getZooname() {
		return zooname;
	}

	public void setZooname(String zooname) {
		this.zooname = zooname;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	public List<ZooAnimal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<ZooAnimal> animals) {
		this.animals = animals;
	}
}
