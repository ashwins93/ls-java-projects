package com.lambdaschool.javaorders.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order {
//	ORDNUM primary key, not null Long
//	ORDAMOUNT double
//	ADVANCEAMOUNT double
//	CUSTCODE Long foreign key (one customer to many orders) not null
//	ORDERDESCRIPTION String

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ordnum;

	private double ordamount;
	private double advanceamount;
	private String orderdescription;

	@ManyToOne
	@JoinColumn(name = "custcode", nullable = false)
	@JsonIgnoreProperties(value = { "orders", "agent" })
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "orderspayments",
			   joinColumns = @JoinColumn(name = "ordnum"), 
			   inverseJoinColumns = @JoinColumn(name = "paymentid"))
	@JsonIgnoreProperties(value = { "orders" }, allowSetters = true)
	private List<Payment> payments = new ArrayList<Payment>();

	public Order() {
	}

	public Order(double ordamount, double advanceamount, String orderdescription, Customer customer) {
		super();
		this.ordamount = ordamount;
		this.advanceamount = advanceamount;
		this.orderdescription = orderdescription;
		this.customer = customer;
	}

	public long getOrdnum() {
		return ordnum;
	}

	public void setOrdnum(long ordnum) {
		this.ordnum = ordnum;
	}

	public double getOrdamount() {
		return ordamount;
	}

	public void setOrdamount(double ordamount) {
		this.ordamount = ordamount;
	}

	public double getAdvanceamount() {
		return advanceamount;
	}

	public void setAdvanceamount(double advanceamount) {
		this.advanceamount = advanceamount;
	}

	public String getOrderdescription() {
		return orderdescription;
	}

	public void setOrderdescription(String orderdescription) {
		this.orderdescription = orderdescription;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public void addPayment(Payment payment) {
		payments.add(payment);
		payment.getOrders().add(this);
	}
	
	public void removePayment(Payment payment) {
		payments.remove(payment);
		payment.getOrders().remove(this);
	}
}
