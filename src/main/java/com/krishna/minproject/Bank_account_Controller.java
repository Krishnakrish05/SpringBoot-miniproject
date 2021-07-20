package com.krishna.minproject;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.apache.log4j.Logger;


@RestController
public class Bank_account_Controller {
	
	@Autowired
	Bank_account_Repo data;
	
	@Autowired
	Transaction_Repo data1;
	
	 private final Logger LOGGER = Logger.getLogger(Bank_account_Controller.class.getName());
	
	@RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
	
	@PostMapping("/postaccount")
	public Bank_account addAccount(@Valid @RequestBody Bank_account acc) {
		if(acc.getAccount_type().equals("SAVINGS")){
			acc.setTransaction_fee(5);
		}else {
			acc.setTransaction_fee(0);
		}
		LocalDateTime d = LocalDateTime.now();
		acc.setCreated_at(d);
		acc.setUpdated_at(d);
		
		 data.save(acc);
		 LOGGER.info("Save a bank account"+acc.toString());
		return acc;
		
	}
	
	@PostMapping("/transaction/{account_number}")
	public ResponseTransaction postTransaction(@RequestBody RequestTransaction tra,@PathVariable int account_number ) throws Exception{
		
		Transaction trans=new Transaction();
		trans.setAmount(tra.getAmount());
		//System.out.println("Getting amount for transaction"+trans.getAmount());
		trans.setType(tra.getType());
		Optional<Bank_account> num=data.findById(account_number);
		Bank_account getacc=num.get();
		trans.setBank_account(getacc);
		
		float bal=getacc.getInitialdeposit();
	System.out.print("Inital Deposit"+bal);
	
		trans.setBalance(bal);
		trans.setTransaction_status("FAILURE");
		float newbal;
		if(tra.getType().equals("WITHDRAW")) {
			newbal=bal - trans.getAmount() - trans.getBank_account().getTransaction_fee();
			if(newbal<0) {
				throw new Exception("Amount cant be withdrawn");
			}
			trans.setBalance(newbal);
			trans.getBank_account().setInitialdeposit(newbal);
			trans.setTransaction_status("SUCCESS");

				}else if(tra.getType().equals("DEPOSIT")) {
					newbal = bal + trans.getAmount() - trans.getBank_account().getTransaction_fee();
						
						trans.setBalance(newbal);
						trans.getBank_account().setInitialdeposit(newbal);
						trans.setTransaction_status("SUCCESS");
					}else {
						trans.setTransaction_status("FAIL");
						throw new Exception("Cannot define unknown word");
						
					}
				
				LocalDateTime d = LocalDateTime.now();
						Date date= new Date();
			    trans.setTransaction_date(date);
				trans.setCreated_at(d);
				trans.setUpdated_at(d);	
				
				data1.save(trans);
				LOGGER.info("Transaction /transaction/"+account_number+tra.toString());
				
				ResponseTransaction response = new ResponseTransaction();
				response.setTransaction_id(trans.getTransaction_id());
				response.setAcc_num(account_number);
				response.setAmount(trans.getAmount());
				response.setType(trans.getType());
				response.setBalance(trans.getBalance());
				response.setTransaction_date(trans.getTransaction_date());
				response.setTransaction_status(trans.getTransaction_status());
				response.setCreated_at(trans.getCreated_at());
				response.setUpdated_at(trans.getUpdated_at());
				
				return response;
			
		}
	
	@GetMapping("/gettransaction/{account_number}")
	public GetResponse getTransactions(@PathVariable int account_number) {
		Optional<Bank_account> account=data.findById(account_number);
		Bank_account ac= account.get();
		
		List<Transaction> acc=data1.getTrans(account_number);
		GetResponse get=new GetResponse();
		get.setAcc_num(ac.getAccount_number());
		get.setAccount_holder_name(ac.getAccount_holder_name());
		get.setDateofbirth(ac.getDateofbirth());
		get.setAccount_type(ac.getAccount_type());
		get.setInitialdeposit(ac.getInitialdeposit());
		get.setTransactions(acc);
		
		return get;
	
		
	}	
	
	}
	
	


