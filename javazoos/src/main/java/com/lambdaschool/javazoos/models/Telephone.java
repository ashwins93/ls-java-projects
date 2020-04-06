package com.lambdaschool.javazoos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telephones")
public class Telephone extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long phoneid;
	
	@Column(nullable = false)
	private String phonenumber;
	private String phonetype;
	
	@ManyToOne
	@JoinColumn(name = "zooid")
	private Zoo zoo;

	public Telephone() {
		super();
	}

	public Telephone(String phonenumber, String phonetype, Zoo zoo) {
		super();
		this.phonenumber = phonenumber;
		this.phonetype = phonetype;
		this.zoo = zoo;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPhonetype() {
		return phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public Zoo getZoo() {
		return zoo;
	}

	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}
}
