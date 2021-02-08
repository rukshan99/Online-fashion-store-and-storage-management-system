package com.OnlineFashionStore.customer.jpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendance {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="attendance_id")
	private long attendance_id;
	
	@Column(name="Employee_id")
	private String employeeId;
	
	@Column(name="Date")
	private String date;
    
    @Column(name="OnTime")
    private String ont;

	public long getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(long attendance_id) {
		this.attendance_id = attendance_id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOnt() {
		return ont;
	}

	public void setOnt(String ont) {
		this.ont = ont;
	}



	
	
}

