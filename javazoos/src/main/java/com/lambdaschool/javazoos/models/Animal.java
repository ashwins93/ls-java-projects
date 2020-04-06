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
@Table(name = "animals")
public class Animal extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long animalid;
	
	@Column(nullable = false)
	private String animaltype;
	
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "animal")
	private List<ZooAnimal> zoos;

	public Animal() {
		super();
	}

	public Animal(String animaltype, List<ZooAnimal> zoos) {
		super();
		this.animaltype = animaltype;
		this.zoos = zoos;
	}

	public long getAnimalid() {
		return animalid;
	}

	public void setAnimalid(long animalid) {
		this.animalid = animalid;
	}

	public String getAnimaltype() {
		return animaltype;
	}

	public void setAnimaltype(String animaltype) {
		this.animaltype = animaltype;
	}

	public List<ZooAnimal> getZoos() {
		return zoos;
	}

	public void setZoos(List<ZooAnimal> zoos) {
		this.zoos = zoos;
	}
}
