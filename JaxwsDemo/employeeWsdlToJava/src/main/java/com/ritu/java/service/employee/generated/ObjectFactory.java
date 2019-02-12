
package com.ritu.java.service.employee.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ritu.java.service.employee.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmployeeInfoList_QNAME = new QName("http://bestpay.payroll/employee", "EmployeeInfoList");
    private final static QName _UserDefinedFault_QNAME = new QName("http://bestpay.payroll/employee", "UserDefinedFault");
    private final static QName _EmployeeIdList_QNAME = new QName("http://bestpay.payroll/employee", "EmployeeIdList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ritu.java.service.employee.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmployeeInfoWrapper }
     * 
     */
    public EmployeeInfoWrapper createEmployeeInfoWrapper() {
        return new EmployeeInfoWrapper();
    }

    /**
     * Create an instance of {@link UserDefinedFault }
     * 
     */
    public UserDefinedFault createUserDefinedFault() {
        return new UserDefinedFault();
    }

    /**
     * Create an instance of {@link EmployeeIdWrapper }
     * 
     */
    public EmployeeIdWrapper createEmployeeIdWrapper() {
        return new EmployeeIdWrapper();
    }

    /**
     * Create an instance of {@link EmployeeInfo }
     * 
     */
    public EmployeeInfo createEmployeeInfo() {
        return new EmployeeInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeInfoWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bestpay.payroll/employee", name = "EmployeeInfoList")
    public JAXBElement<EmployeeInfoWrapper> createEmployeeInfoList(EmployeeInfoWrapper value) {
        return new JAXBElement<EmployeeInfoWrapper>(_EmployeeInfoList_QNAME, EmployeeInfoWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDefinedFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bestpay.payroll/employee", name = "UserDefinedFault")
    public JAXBElement<UserDefinedFault> createUserDefinedFault(UserDefinedFault value) {
        return new JAXBElement<UserDefinedFault>(_UserDefinedFault_QNAME, UserDefinedFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeIdWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bestpay.payroll/employee", name = "EmployeeIdList")
    public JAXBElement<EmployeeIdWrapper> createEmployeeIdList(EmployeeIdWrapper value) {
        return new JAXBElement<EmployeeIdWrapper>(_EmployeeIdList_QNAME, EmployeeIdWrapper.class, null, value);
    }

}
