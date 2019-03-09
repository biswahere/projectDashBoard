package com.techprimers.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.techprimers.stock.filter.ErrorFilter;
import com.techprimers.stock.filter.PostFilter;
import com.techprimers.stock.filter.PreFilter;
import com.techprimers.stock.filter.RouteFilter;





@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZullServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullServiceApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}

