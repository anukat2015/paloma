package com.paloit.paloma.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paloit.paloma.dto.UserDTO;

/**
 * REST controller for managing user.
 */
@RestController
@RequestMapping("/user")
public class UserResource {

	
	/**
     *  method to log an user.
     */
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void login(@RequestBody UserDTO userDTO){
        
    	if (null != userDTO && null != userDTO.getEmail() && null != userDTO.getPassword()){
    		
    	}
    }
    
    
    /**
     *  method to log out an user.
     */
    @RequestMapping(value = "/logout",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void logout(){
        
    	
    }
}
