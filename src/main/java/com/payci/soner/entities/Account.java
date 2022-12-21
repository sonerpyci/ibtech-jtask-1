package com.payci.soner.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	public Account() {}
	
	public Account(double balance) {
		this.balance = balance;
	}

	public Account(long id, double balance) {
		this(balance);
		this.id = id;
	}

	public Account(long id, double balance, Customer customer) {
		this(id, balance);
		this.customer = customer;
	}

	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

	private double balance;

	@ManyToOne
    @JoinColumn(name="customer_id")
	
    private Customer customer;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();

        return sb.append("Account : \n Id : ").append(id)
        		.append("\nBalance : ").append(balance)
        		.toString();
    }
}
