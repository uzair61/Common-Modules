package com.jhola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhola.dto.ProductDTO;
import com.jhola.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductAPI {
	
	@Autowired
	public ProductService service;
	
//	 @PreAuthorize("hasUserName('Admin@gmail.com')")
	 @CrossOrigin
	 @PostMapping("/")
	 public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		 service.createProduct(productDTO);
		 return new ResponseEntity<String>("Product Added to the Application" , HttpStatus.CREATED);
	 }
	 
	 @CrossOrigin
	 @GetMapping("/{productId}")
	 public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId){
		 ProductDTO productDTO = service.getProductById(productId);
		 if(productDTO == null) {
			 return new ResponseEntity<>( null, HttpStatus.BAD_REQUEST);
		 }
		 return new ResponseEntity<>(productDTO , HttpStatus.OK);
	 }
	 
	 @CrossOrigin
	 @PutMapping("/{productId}")
	 public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO , @PathVariable Long productId){
		 boolean updateProduct = service.updateProduct(productId, productDTO);
		 if( updateProduct == true ) {
		 return new ResponseEntity<String>("Product Updated" , HttpStatus.OK);
		 } else {
			 return new ResponseEntity<String>("Invalid Product i.e, Product Not Found" , HttpStatus.BAD_REQUEST);
		 }
	 }
	 
	 @CrossOrigin
	 @DeleteMapping("/{productId}")
	 public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
		 service.deleteProduct(productId);
		 return new ResponseEntity<>("Product Deleted" , HttpStatus.OK);
	 }
	 
	 @CrossOrigin
	 @GetMapping("/")
	 public ResponseEntity<List<ProductDTO>> getAllProduct(){
		 List<ProductDTO> allProducts = service.getAllProduct();
		 return new ResponseEntity<>( allProducts , HttpStatus.OK);
	 }

	 @CrossOrigin
	 @GetMapping("/filter/{category}")
	 public ResponseEntity<List<ProductDTO>> getProductByCatogery(@PathVariable String category){
		 List<ProductDTO> listOfProducts = service.getProductByCategory(category);
		 return new ResponseEntity<>( listOfProducts , HttpStatus.OK);
	 }
	 
	

}
