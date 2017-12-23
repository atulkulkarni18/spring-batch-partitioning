package com.javasampleapproach.partitioning.step;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.javasampleapproach.partitioning.model.Customer;


public class Processor implements ItemProcessor<Customer, Customer> {

	private static final Logger log = LoggerFactory.getLogger(Processor.class);

	private String threadName;
	
	@Override
	public Customer process(Customer customer) throws Exception {
		Random r = new Random();
		
		final String firstName = customer.getFirstName().toUpperCase();
		final String lastName = customer.getLastName().toUpperCase();
		final Customer fixedCustomer = new Customer(r.nextInt(), firstName, lastName);

		log.info(threadName + " processing : "+ "Converting (" + customer + ") into (" + fixedCustomer + ")");
		
		return fixedCustomer;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
}