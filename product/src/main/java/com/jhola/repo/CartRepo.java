package com.jhola.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhola.model.Cart;
import com.jhola.security.model.User;

@Repository
public interface CartRepo extends CrudRepository< Cart , Long >{
	
	public Cart findCartByUser(User user);

}
