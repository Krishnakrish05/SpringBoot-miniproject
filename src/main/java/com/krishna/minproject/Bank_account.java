package com.krishna.minproject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank_account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int account_number;
	@NotBlank(message = "Name is mandatory")
	private String account_holder_name;	
	
	private String dateofbirth;
	
	private String account_type;
	private float transaction_fee;
	
	@Min(0)
	private float initialdeposit;
	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acc_num",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Transaction> transactions = new HashSet<>();
	
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public float getTransaction_fee() {
		return transaction_fee;
	}
	public void setTransaction_fee(float transaction_fee) {
		this.transaction_fee = transaction_fee;
	}
	public float getInitialdeposit() {
		return initialdeposit;
	}
	public void setInitialdeposit(float initialdeposit) {
		this.initialdeposit = initialdeposit;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	

}
