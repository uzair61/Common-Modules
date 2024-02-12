package com.jhola.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhola.dto.ProductDTO;
import com.jhola.model.Categories;
import com.jhola.model.Product;
import com.jhola.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public ProductRepo repo;
	
	public boolean createProduct(ProductDTO productDTO){
		Product product = mapper.map(productDTO, Product.class);
		repo.save(product);
		return true;
	}
	
	public ProductDTO getProductById(Long productId) {
		Optional<Product> productDetails = repo.findById(productId);
		Product product = productDetails.get();
		if (product.isDeleted() == false) {
		ProductDTO productDTO = mapper.map(product, ProductDTO.class);
		return productDTO;
		} return null;
	}
	
	public List<ProductDTO> getAllProduct() {
		List<ProductDTO> listOfProducts = new ArrayList<ProductDTO>();
		Iterable<Product> allProducts = repo.findAll();
		allProducts.forEach( (products) -> {
			listOfProducts.add(mapper.map(products, ProductDTO.class));
		    });
		return listOfProducts;
	}
	
	
	public boolean updateProduct(Long productId , ProductDTO productDTO) {
		Optional<Product> productDetails = repo.findById(productId);
		Product product = productDetails.get();
		if (product.isDeleted() == false) {
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		repo.save(product);
		return true;
		} else { 
			return false;
		}
	}
	
	public boolean deleteProduct(Long productId) {
		Optional<Product> product = repo.findById(productId);
		Product prod = product.get();
		prod.setDeleted(true);
		repo.save(prod);
		return true;
	}
	
	public List<ProductDTO> getProductByCategory(String category){
		List<Product> listOfProducts = repo.findProductByCategory(Categories.valueOf(category));
		List<ProductDTO> listOfProductsDTO = new ArrayList<>();
		for ( Product product : listOfProducts) {
			ProductDTO productDTO = mapper.map(product, ProductDTO.class);
			listOfProductsDTO.add(productDTO);
		}
		return listOfProductsDTO;
	}
	
	


}
