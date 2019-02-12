package com.ritu.java.endpoint.publisher;

import javax.xml.ws.Endpoint;

import com.ritu.java.service.employee.impl.EmployeeLookupServiceImpl_WSDL;

public class PublishEndpoint {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9990/EmployeeLookupService", new EmployeeLookupServiceImpl_WSDL());

		System.out.println("EmployeeLookupService Started!");
	}

}
