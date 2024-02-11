package com.springboot.demo.services;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.demo.config.WebConfig;

@Service
public class RestApiHandler {

	@Autowired
	WebConfig config;
	
	public void authorize() throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		RestTemplate restTemplate = config.getRestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(new String(""));
		String tokenUrl
		  = "https://localhost:9002/authorizationserver/oauth/token?grant_type=client_credentials&client_id=mobile_android&client_secret=secret";
		ResponseEntity<String> response
		  = restTemplate.exchange(tokenUrl,HttpMethod.POST,request,String.class);
		System.out.println(response);

	}
}
