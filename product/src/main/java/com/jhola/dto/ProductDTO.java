package com.jhola.dto;



import java.io.Serializable;

import com.jhola.model.BaseEntity;
import com.jhola.model.Categories;

public class ProductDTO extends BaseEntity implements Serializable{

	
	private static final long serialVersionUID = 404987189608886285L;

	private Categories category;

	private String name;

	private String description;

	private Long price;



	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + ", category=" + category + ", name=" + name + ", description="
				+ description + ", price=" + price + ", isDeleted=" + "]";
	}

    
	

}
