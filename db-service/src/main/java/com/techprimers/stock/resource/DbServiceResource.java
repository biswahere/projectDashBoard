package com.techprimers.stock.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.stock.model.Quote;
import com.techprimers.stock.model.Quotes;
import com.techprimers.stock.repository.QuotesRepository;



@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {
	
    @Autowired
	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	public List<Quote> quotes(@PathVariable("username") final String username){
		
		return getQuotesByUserName (username);
	
	}
	
	
	@PostMapping("/add")
	public List<Quote> add(@RequestBody final Quotes quotes){
		
		System.out.println("jai mata di");
		quotes.getQuotes()
			.stream()
			.map(quote -> new Quote(quotes.getUserName(), quote))
			.forEach(quote ->  {
				quotesRepository.save(quote);
				
			});
				
		
		return getQuotesByUserName (quotes.getUserName());
	}
	
	
	
	@PostMapping("/delete/{id}")
	public List<Quote> delete (@PathVariable("id") final Integer Id) {
			
		quotesRepository.deleteById(Id);;
		System.out.println("deleted");
		return quotesRepository.findAll();
		
	}
	
	public List<Quote> getQuotesByUserName(String username){
		return quotesRepository.findByUserName(username);
		//.stream()
		//.map(Quote :: getQuote)
		//.collect(Collectors.toList());
	}
	}

