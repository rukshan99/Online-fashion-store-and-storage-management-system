package com.OnlineFashionStore.customer.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private long employeeid;
	
    @Column(name="email")
    private String employeeEmail;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="dob")
    private String dob;
    
   @Column(name="Contact_number")
    private String Contactnumber;
    
    @Column(name="Home_address")
    private String Homeadress;
    
    @Column(name="salary")
    private String salary;

    
    //getters setters

	public String getFirstName() {
		return firstName;
	}

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactnumber() {
		return Contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		Contactnumber = contactnumber;
	}

	public String getHomeadress() {
		return Homeadress;
	}

	public void setHomeadress(String homeadress) {
		Homeadress = homeadress;
	}
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
    
    
    
  
}
