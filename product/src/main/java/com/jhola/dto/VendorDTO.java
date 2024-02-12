package com.jhola.dto;

import java.io.Serializable;

import com.jhola.model.BaseEntity;

public class VendorDTO extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 2373176196427356692L;
	
	
	private String vendorName;
	
	private String vendorAddress;

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
