package com.jhola.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jhola.dto.ProductDTO;
import com.jhola.model.Images;
import com.jhola.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductAPI {
	
	@Autowired
	public ProductService service;
	

	 @CrossOrigin
	 @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} )
	 public ResponseEntity<String> createProduct(@RequestPart("product") ProductDTO productDTO, 
			                                     @RequestPart("imageFile") MultipartFile[] file, 
	                                             @RequestHeader String userName){
		 try {
			Set<Images> image = uploadImage(file);
			productDTO.setProductImages(image);
			service.createProduct(productDTO);
			return new ResponseEntity<String>("Product Added to the Application" , HttpStatus.CREATED);			
		} catch (Exception e) {
			 System.out.println(e.getMessage());
	         return null;
		}
	 }
	 
	 public Set<Images> uploadImage(MultipartFile[] multipartFiles) throws IOException {
	        Set<Images> imageModels = new HashSet<>();

	        for (MultipartFile file: multipartFiles) {
	            Images image = new Images(
	                    file.getOriginalFilename(),
	                    file.getBytes()
	            );
	            imageModels.add(image);
	        }

	        return imageModels;
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
