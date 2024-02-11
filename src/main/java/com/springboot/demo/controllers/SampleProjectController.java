package com.springboot.demo.controllers;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import com.springboot.demo.services.RestApiHandler;
 
@RestController
@EnableAutoConfiguration
public class SampleProjectController {
 
	@Autowired
	RestApiHandler restApiHandler;
	
	
    @RequestMapping("/")
    String home() throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
    	restApiHandler.authorize();
        return "Hello World!";
    }
}