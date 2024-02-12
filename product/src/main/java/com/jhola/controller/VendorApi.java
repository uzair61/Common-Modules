package com.jhola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhola.dto.VendorDTO;
import com.jhola.service.VendorService;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorApi {
	
	@Autowired
	private VendorService service;
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<String> createVendor(@RequestBody VendorDTO vendorDTO){
		service.createVendor(vendorDTO);
		return new ResponseEntity<>("Vendor Created!!!" , HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/{vendorId}")
	public ResponseEntity<VendorDTO> getVendorById(@PathVariable Long vendorId){
    	VendorDTO vendorDTO = service.getVendorById(vendorId);
		if(vendorDTO == null) {
		 return new ResponseEntity<>( null, HttpStatus.BAD_REQUEST);
      	}
		 return new ResponseEntity<>(vendorDTO , HttpStatus.OK);
	 }
	
	 @CrossOrigin
	 @GetMapping("/")
	 public ResponseEntity<List<VendorDTO>> getAllVendor(){
		 List<VendorDTO> allVendors = service.getAllVendor();
		 return new ResponseEntity<>( allVendors , HttpStatus.OK);
	 }
	
	 @CrossOrigin
	 @PutMapping("/{vendorId}")
	 public ResponseEntity<String> updateVendor(@RequestBody VendorDTO vendorDTO , @PathVariable Long vendorId){
		 boolean updateVendor = service.updateVendor(vendorId, vendorDTO);
		 if( updateVendor == true ) {
		 return new ResponseEntity<String>("Vendor Updated" , HttpStatus.OK);
		 } else {
			 return new ResponseEntity<String>("Invalid Vendor i.e, Vendor Not Found" , HttpStatus.BAD_REQUEST);
		 }
	 }
	 
	 @CrossOrigin
	 @DeleteMapping("/{vendorId}")
	 public ResponseEntity<String> deleteVendor(@PathVariable Long vendorId){
		 service.deleteVendor(vendorId);
		 return new ResponseEntity<>("Vendor Deleted" , HttpStatus.OK);
	 }
	

}
