package com.krishna.minproject;

import java.util.List;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Transaction_Repo extends CrudRepository<Transaction, Integer> {
	
    

//	List<Transaction> findAllById(Transaction getBank_account);
	@Query("from Transaction where acc_num.account_number=?1")
	public List<Transaction> getTrans(int account_number);

	
	
}
