package com.jaxrs.resteasy.application.resource;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jaxrs.resteasy.application.domain.Employee;
import com.jaxrs.resteasy.application.domain.GenericResponse;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"ADMIN", "ORG1", "DEV1", "ADMIN1"})
public class EmployeeResource {

private static Map<Integer,Employee> emps = new HashMap<Integer,Employee>();
	
	@POST
    @Path("/add")
	@RolesAllowed("DEV1")
	public Response addEmployee(Employee e) {
		GenericResponse response = new GenericResponse();
		if(emps.get(e.getId()) != null){
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		emps.put(e.getId(), e);
		response.setStatus(true);
		response.setMessage("Employee created successfully");
		return Response.ok(response).build();
	}

	@DELETE
    @Path("/{id}/delete")
	@DenyAll
	public Response deleteEmployee(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if(emps.get(id) == null){
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		emps.remove(id);
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return Response.ok(response).build();
	}

	@GET
	@Path("/{id}/get")
	@RolesAllowed("ADMIN1")
	public Employee getEmployee(@PathParam("id") int id) {
		return emps.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	@PermitAll
	public Employee getDummyEmployee(@PathParam("id") int id) {
		Employee e = new Employee();
		e.setSalary(8976.55);
		e.setName("Dummy");
		e.setId(id);
		return e;
	}

	@GET
	@Path("/getAll")
	@RolesAllowed("ADMIN")
	public Employee[] getAllEmployees() {
		Set<Integer> ids = emps.keySet();
		Employee[] e = new Employee[ids.size()];
		int i=0;
		for(Integer id : ids){
			e[i] = emps.get(id);
			i++;
		}
		return e;
	}
}

