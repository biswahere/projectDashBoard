package com.techprimers.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.stock.model.Quote;

public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByUserName(String username);
	    

}
