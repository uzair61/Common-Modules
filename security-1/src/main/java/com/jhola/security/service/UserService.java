package com.jhola.security.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jhola.security.dto.UserDTO;
import com.jhola.security.exception.UsernameAlreadyExistsException;
import com.jhola.security.model.User;
import com.jhola.security.repo.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (UserDTO newUser){

        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            
            //Username has to be unique (exception)
            newUser.setUsername(newUser.getUsername());
            
            // Make sure that password and confirmPassword match
            // We don't persist or show the confirmPassword
            newUser.setConfirmPassword("");
            
            User user = modelMapper.map(newUser, User.class);
            
            return userRepository.save(user);

        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists");
        }

    }



}
