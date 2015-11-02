package com.paloit.paloma.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paloit.paloma.dto.UserDTO;

/**
 * REST controller for managing user.
 */
@RestController
@RequestMapping("/app")
public class UserResource {

	/**
     *  method to log an user.
     */
    @RequestMapping(value = "/user/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void login(@RequestBody UserDTO userDTO){
        
    }
    
    
    /**
     *  method to log out an user.
     */
    @RequestMapping(value = "/user/logout",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void logout(){
        
    }
}
