package com.ritu.java.server.endpoint.publish;

import javax.xml.ws.Endpoint;

import com.ritu.java.service.impl.HelloWorldServiceImpl;

public class EndpointPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9980/helloworld", new HelloWorldServiceImpl());
		System.out.println("HelloworldServices Started!");
	}
}
