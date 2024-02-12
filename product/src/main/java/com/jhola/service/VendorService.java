package com.jhola.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhola.dto.VendorDTO;
import com.jhola.model.Vendor;
import com.jhola.repo.VendorRepo;

@Service
public class VendorService {
	
	@Autowired
	public VendorRepo repo;
	
	@Autowired
	public ModelMapper mapper;
	
	
	public boolean createVendor(VendorDTO vendorDTO) {
		Vendor vendor = mapper.map(vendorDTO, Vendor.class);
		repo.save(vendor);
		return true;
	}
	
	public VendorDTO getVendorById(Long vendorId) {
		Optional<Vendor> vendorDetails = repo.findById(vendorId);
		Vendor vendor = vendorDetails.get();
		if (vendor.isDeleted() == false) {
		VendorDTO vendorDTO = mapper.map(vendor, VendorDTO.class);
		return vendorDTO;
		} return null;
	}
	
	public List<VendorDTO> getAllVendor() {
		List<VendorDTO> listOfVendors = new ArrayList<VendorDTO>();
		Iterable<Vendor> allVendors = repo.findAll();
		allVendors.forEach( (vendors) -> {
			listOfVendors.add(mapper.map(vendors, VendorDTO.class));
		    });
		return listOfVendors;
	}
	
	public boolean updateVendor(Long vendorId , VendorDTO vendorDTO) {
		Optional<Vendor> vendorDetails = repo.findById(vendorId);
		Vendor vendor = vendorDetails.get();
		if (vendor.isDeleted() == false) {
		vendor.setVendorName(vendor.getVendorName());
		vendor.setVendorAddress(vendor.getVendorAddress());
		repo.save(vendor);
		return true;
		} else { 
			return false;
		}
	}
	
	public boolean deleteVendor(Long vendorId) {
		Optional<Vendor> vendor = repo.findById(vendorId);
		Vendor vendorDetails = vendor.get();
		vendorDetails.setDeleted(true);
		repo.save(vendorDetails);
		return true;
	}

}
