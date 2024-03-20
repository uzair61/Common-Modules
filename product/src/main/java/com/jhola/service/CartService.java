package com.jhola.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jhola.controller.ProductAPI;
import com.jhola.dto.ProductDTO;
import com.jhola.model.Cart;
import com.jhola.model.Product;
import com.jhola.repo.CartRepo;
import com.jhola.security.model.User;
import com.jhola.security.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	private CartRepo cartRepo;
	
	
	private Cart cart = new Cart();
	
	User user = new User();
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductAPI productApi;
	
	@Autowired
//	private ModelMapper mapper;
	
	public void createCartForUser(User user) {
		cart.setUser(user);
		cartRepo.save(cart);
	}
	
	@SuppressWarnings("null")
	public boolean addToCart(Long productId, String userName) {
		ResponseEntity<ProductDTO> productById = productApi.getProductById(productId);
		ProductDTO productDTO = productById.getBody();
		//Product product = mapper.map(productDTO, Product.class);
		//List<Product> products = null;
		//products.add(product);
		
		
		user = userRepo.findByUsername(userName);
		Cart cartByUser = cartRepo.findCartByUser(user);
		cartByUser.setProduct(productDTO);
		
		return true;
		
	}
	
	
}
