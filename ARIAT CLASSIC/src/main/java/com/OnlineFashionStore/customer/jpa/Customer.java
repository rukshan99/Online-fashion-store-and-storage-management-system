package com.OnlineFashionStore.customer.jpa;

import javax.persistence.*;



@Entity
public class Customer {
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long userid;

    private String emailId;

    private String password;

    @Column(name="first_name") 
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="dob")
    private String dob;
      
    @Column(name="telephone")
    private String telephone;
    
    @Column(name="street")
    private String street;
    
    @Column(name="city")
    private String city;
    
    @Column(name="district")
    private String district;
    
    @Column(name="province")
    private String province;
    
    private boolean isEnabled;
    
    @Column(name="Role")
    private String roleid="USER";
    
    
	public Customer(long userid, String emailId, String password, String firstName, String lastName, String dob,
			String telephone, String street, String city, String district, String province, boolean isEnabled,
			String roleid) {
		this.userid = userid;
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.telephone = telephone;
		this.street = street;
		this.city = city;
		this.district = district;
		this.province = province;
		this.isEnabled = isEnabled;
		this.roleid = roleid;
	}

	public Customer() {
		
		this.emailId = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.dob = "";
		this.telephone = "";
		this.street = "";
		this.city = "";
		this.district = "";
		this.province = "";
		this.isEnabled = false;
		this.roleid = "ROLE_USER";
	}

	public Customer(String emailId, String password, String roleid) {
	
		this.emailId = emailId;
		this.password = password;
		this.roleid = roleid;
	}


    
    // getters and setters
    public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
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

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	

}
