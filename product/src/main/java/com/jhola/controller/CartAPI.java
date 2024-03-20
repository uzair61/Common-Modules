package com.jhola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jhola.service.CartService;

@RestController("api/v1/cart")
public class CartAPI {
	
	@Autowired
	private CartService cartService;

	@PutMapping("/{productId}")
	public ResponseEntity<String> addToCart(@PathVariable Long productId , @RequestHeader String userName) {
		
		boolean addToCart = cartService.addToCart(productId, userName);
		
		if( addToCart == true) {
		return new ResponseEntity<String>("Product Added to the Cart" , HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Product not added" , HttpStatus.CONFLICT);	
	}
	
}
