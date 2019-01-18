# JAX-WS-SampleProject
Java API for XML Web Services (JAX-WS) is a standardized API for creating and consuming SOAP (Simple Object Access Protocol) web services.

SOAP
SOAP is an XML specification for sending messages over a network. SOAP messages are independent of any operating system and can use a variety of communication protocols including HTTP and SMTP.
SOAP is XML heavy, hence best used with tools/frameworks. JAX-WS is a framework that simplifies using SOAP. It is part of standard Java.

Top-Down vs. Bottom-Up
There are two ways of building SOAP web services. We can go with a top-down approach or a bottom-up approach.
In a top-down (contract-first) approach, a WSDL document is created, and the necessary Java classes are generated from the WSDL. In a bottom-up (contract-last) approach, the Java classes are written, and the WSDL is generated from the Java classes.
Writing a WSDL file can be quite difficult depending on how complex your web service is. This makes the bottom-up approach an easier option. On the other hand, since your WSDL is generated from the Java classes, any change in code might cause a change in the WSDL. This is not the case for the top-down approach.

Web Services Definition Language (WSDL)
WSDL is a contract definition of the available services. It is a specification of input/output messages, and how to invoke the web service. It is language neutral and is defined in XML.

Definitions
The definitions element is the root element of all WSDL documents. It defines the name, the namespace, etc. of the service and, as you can see, can be quite spacious:
<definitions xmlns="http://schemas.xmlsoap.org/wsdl/"
  xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
  xmlns:tns="http://jaxws.baeldung.com/"
  xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata"
  xmlns:wsp="http://www.w3.org/ns/ws-policy"
  xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy"
  xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
  xmlns:xsd="http://www.w3.org/2001/XMLSchema"
  targetNamespace="http://jaxws.baeldung.com/"
  name="EmployeeService">
  ...
</definitions>

Types
The types element defines the data types used by the web service. WSDL uses XSD (XML Schema Definition) as the type system which helps with interoperability:
<definitions ...>
    ...
    <types>
        <xsd:schema>
            <xsd:import namespace="http://jaxws.baeldung.com/"
              schemaLocation = "http://localhost:8080/employeeservice?xsd=1" />
        </xsd:schema>
    </types>
    ...
</definitions>

Messages
The message element provides an abstract definition of the data being transmitted. Each message element describes the input or output of a service method and the possible exceptions:
<definitions ...>
    ...
    <message name="getEmployee">
        <part name="parameters" element="tns:getEmployee" />
    </message>
    <message name="getEmployeeResponse">
        <part name="parameters" element="tns:getEmployeeResponse" />
    </message>
    <message name="EmployeeNotFound">
        <part name="fault" element="tns:EmployeeNotFound" />
    </message>
    ...
</definitions>

Operations and Port Types
The portType element describes each operation that can be performed and all the message elements involved. For example, the getEmployee operation specifies the request input, output and possible fault exception thrown by the web service operation:
<definitions ...>
    ...
    <portType name="EmployeeService">
        <operation name="getEmployee">
            <input
              wsam:Action="http://jaxws.baeldung.com/EmployeeService/getEmployeeRequest"
              message="tns:getEmployee" />
            <output
              wsam:Action="http://jaxws.baeldung.com/EmployeeService/getEmployeeResponse"
              message="tns:getEmployeeResponse" />
            <fault message="tns:EmployeeNotFound" name="EmployeeNotFound"
              wsam:Action="http://jaxws.baeldung.com/EmployeeService/getEmployee/Fault/EmployeeNotFound" />
        </operation>
    ....
    </portType>
    ...
</definitions>

Bindings
The binding element provides protocol and data format details for each portType:
<definitions ...>
    ...
    <binding name="EmployeeServiceImplPortBinding"
      type="tns:EmployeeService">
        <soap:binding transport="http://schemas.xmlsoap.org/soap/http"
          style="document" />
        <operation name="getEmployee">
            <soap:operation soapAction="" />
            <input>
                <soap:body use="literal" />
            </input>
            <output>
                <soap:body use="literal" />
            </output>
            <fault name="EmployeeNotFound">
                <soap:fault name="EmployeeNotFound" use="literal" />
            </fault>
        </operation>
        ...
    </binding>
    ...
</definitions>

Services and Ports
The service element defines the ports supported by the web service. The port element in service defines the name, binding and the address of the service:
<definitions ...>
    ...
    <service name="EmployeeService">
        <port name="EmployeeServiceImplPort"
          binding="tns:EmployeeServiceImplPortBinding">
            <soap:address
              location="http://localhost:8080/employeeservice" />
        </port>
    </service>
    ...
</definitions>
