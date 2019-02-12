package com.ritu.java.service.employee.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jws.WebService;

import com.ritu.java.service.employee.generated.EmployeeIdWrapper;
import com.ritu.java.service.employee.generated.EmployeeInfo;
import com.ritu.java.service.employee.generated.EmployeeInfoWrapper;
import com.ritu.java.service.employee.generated.EmployeeLookupService;
import com.ritu.java.service.employee.generated.EmployeeType;
import com.ritu.java.service.employee.generated.ObjectFactory;
import com.ritu.java.service.employee.generated.UserDefinedException;
import com.ritu.java.service.employee.generated.UserDefinedFault;

@WebService(endpointInterface = "com.ritu.java.service.employee.generated.EmployeeLookupService")
public class EmployeeLookupServiceImpl_WSDL implements EmployeeLookupService {
	ObjectFactory of = new ObjectFactory();

	@Override
	public EmployeeInfoWrapper employeeLookup(EmployeeIdWrapper employeeIdList) throws UserDefinedException {
		if (employeeIdList.getEid().isEmpty()) {
			UserDefinedFault e = of.createUserDefinedFault();
			e.setMessage("Empty Employee ID");

			throw new UserDefinedException("Please enter at lease one employee Id", e);
		}

		EmployeeInfoWrapper eWrapper = of.createEmployeeInfoWrapper();

		List allEmps = getEmployees(employeeIdList.getEid());

		eWrapper.getEmployeeInfo().addAll(allEmps);

		return eWrapper;
	}

	private List getEmployees(List<String> ids) {

		List emps = new ArrayList<>();
		for (String id : ids) {
			emps.add(buildDummyEmployee(id, EmployeeType.HOURLY));
		}

		return emps;
	}

	private EmployeeInfo buildDummyEmployee(String id, EmployeeType type) {
		EmployeeInfo emp = of.createEmployeeInfo();
		emp.setEid(id);
		Random rand = new Random();
		emp.setFirstName("FName_" + id);
		emp.setLastName("LName_" + id);
		emp.setType(type);
		emp.setHourlyRate(new BigDecimal(rand.nextInt(40)));
		return emp;
	}

}
