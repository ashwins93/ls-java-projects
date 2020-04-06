package com.lambdaschool.javazoos.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "zooanimals",
	uniqueConstraints = { @UniqueConstraint(columnNames = { "zooid", "animalid" }) })
public class ZooAnimal extends Auditable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "zooid")
	@JsonIgnoreProperties(value = "animals", allowSetters = true)
	private Zoo zoo;

	@Id
	@ManyToOne
	@JoinColumn(name = "animalid")
	@JsonIgnoreProperties(value = "zoos", allowSetters = true)
	private Animal animal;
	
	private String incomingzoo;

	public ZooAnimal() {
		super();
	}

	public ZooAnimal(Zoo zoo, Animal animal, String incomingzoo) {
		super();
		this.zoo = zoo;
		this.animal = animal;
		this.incomingzoo = incomingzoo;
	}

	public Zoo getZoo() {
		return zoo;
	}

	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getIncomingzoo() {
		return incomingzoo;
	}

	public void setIncomingzoo(String incomingzoo) {
		this.incomingzoo = incomingzoo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getZoo(), getAnimal());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZooAnimal other = (ZooAnimal) obj;
		
		return getZoo().equals(other.getZoo()) &&
				getAnimal().equals(other.getAnimal());
	}
}
