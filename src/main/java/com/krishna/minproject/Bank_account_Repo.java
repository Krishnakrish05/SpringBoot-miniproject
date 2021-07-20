package com.krishna.minproject;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Bank_account_Repo extends JpaRepository<Bank_account, Integer> {

//	public default Bank_account getdeposit(int account_number){
//		Bank_account bank=new Bank_account();
//		bank.getAccount_number();
//      bank.getInitialdeposit();
//	return bank;
//		
//	}

	
	
//	@Query("from Transaction where Bank_account.account_number=1")
	

}
