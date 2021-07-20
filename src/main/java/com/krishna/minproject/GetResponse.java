package com.krishna.minproject;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class GetResponse {
	
	
	private int acc_num;
	
	private String account_holder_name;
	
	private String dateofbirth;
	
	private String account_type;
	
	private float initialdeposit;
	@JsonIgnoreProperties(value={"bank_account", "hibernateLazyInitializer"})
	private List<Transaction> transactions;


	public int getAcc_num() {
		return acc_num;
	}


	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
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


	public float getInitialdeposit() {
		return initialdeposit;
	}


	public void setInitialdeposit(float initialdeposit) {
		this.initialdeposit = initialdeposit;
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	

}

