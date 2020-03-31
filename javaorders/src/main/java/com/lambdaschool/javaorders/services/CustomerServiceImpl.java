package com.lambdaschool.javaorders.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.CustomerRepository;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository custrepos;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private PaymentService paymentService;
	

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		custrepos.findAll().iterator().forEachRemaining(customers::add);
		
		return customers;
	}

	@Override
	public Customer findCustomerById(long id) {
		Customer foundCustomer = custrepos
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found " + id));
		
		return foundCustomer;
	}

	@Override
	public List<Customer> searchCustomerByName(String namelike) {
		List<Customer> customers = new ArrayList<>();
		
		custrepos.findAll()
			.iterator()
			.forEachRemaining(customer -> {
				if(customer.getCustname().contains(namelike)) {
					customers.add(customer);
				}
			});
		
		return customers;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer newCustomer = new Customer();
		
		if(customer.getCustcode() != 0) {
			customer.setCustcode(customer.getCustcode());
		}
		
		newCustomer.setCustname(customer.getCustname());
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setWorkingarea(customer.getWorkingarea());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setPhone(customer.getPhone());
		
		Agent agent = agentService.findAgentById(customer.getAgent().getAgentcode());
		
		newCustomer.setAgent(agent);
		
		
		for(Order o : customer.getOrders()) {
			Order newOrder = new Order(
					o.getOrdamount(), 
					o.getAdvanceamount(), 
					o.getOrderdescription(), 
					newCustomer);
			
			for(Payment p : o.getPayments()) {
				Payment payment = paymentService.findPaymentById(p.getPaymentid());
				newOrder.addPayment(payment);
			};
		
			newCustomer.getOrders().add(newOrder);
		}
		
		return custrepos.save(newCustomer);
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerById(long id) {
		// TODO Auto-generated method stub
		
	}

}
