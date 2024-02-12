package com.jhola.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhola.model.Categories;
import com.jhola.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product , Long>{
	
	public List<Product> findProductByCategory(Categories category);
	

}
