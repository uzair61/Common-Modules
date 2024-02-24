package com.jhola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="IMAGES")
public class Images {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long imageId;
	
	private String name;
	
	@Column(length = 10000000)
	private byte[] picByte;

	public Images(String name, byte[] picByte) {
		super();
		this.name = name;
		this.picByte = picByte;
	}
	
	public Images() {
		
	}

	public Long getId() {
		return imageId;
	}

	public void setId(Long id) {
		this.imageId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	
	

}
