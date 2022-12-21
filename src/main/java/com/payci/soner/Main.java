package com.payci.soner;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import com.payci.soner.entities.Account;
import com.payci.soner.entities.Address;
import com.payci.soner.entities.Customer;
import com.payci.soner.entities.Phone;
import com.payci.soner.hibernate.CustomerRepository;

public class Main {

	public static void main(String[] args) {

		CustomerRepository customerRepository = new CustomerRepository();


		Customer customer = new Customer("Soner", "Paycı");
		customerRepository.saveOrUpdate(customer);

		Address address1 = new Address("Manisa", "Salihli", "45300", "bulunamayan adres.");
		Address address2 = new Address("Gebze", "Merkez", "????", "ibtech adres.");
		customer.addAddres(address1);
		customer.addAddres(address2);
		
		Account account = new Account(0.0);
		customer.addAccount(account);
		
		Phone phone = new Phone("+90", "555 222 11 00");
		customer.addPhone(phone);

		customerRepository.saveOrUpdate(customer);
		
		Customer persistentCustomer = customerRepository.get(customer.getId());
		
		System.out.println(persistentCustomer.toString());
		

		List<Address> persistentAddresses = persistentCustomer.getAddresses();
		for (Address addrs : persistentAddresses) {
			System.out.println(addrs.toString());
		}
		
	}

}
