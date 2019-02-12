package com.ritu.java.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ritu.java.model.TopNews;

@WebService
public class HelloWorldServiceImpl{

	@WebMethod
	public String hello(@WebParam(name = "name") String name) {
		return "Hello " + name + "!";
	}

	@WebMethod
	public TopNews getTopNews() {
		TopNews tn = new TopNews();
		tn.setHighlights("Rituraj Kumar published an example for Jax-ws tutorial.");
		tn.setTitle("Jax-WS Tutorial is Available");
		return tn;
	}
}
