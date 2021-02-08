package com.OnlineFashionStore.customer.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	public class Delivery {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="deliveryId")
		private long deliveryId;
		
		@Column(name="Name")
	    private String Name;
		
		@Column(name="address")
		private String address;
	    
	    @Column(name="phone")
	    private String phone;
	    
	    @Column(name="emailId")
	    private String emailId;
	    
	    @Column(name="vehicleNo")
	    private String vehicleNo;
	    
	    @Column(name="OrderId")
	    private String orderId;
	  	    
	    @Column(name="price")
	    private String price;
	    
	    @Column(name="date")
	    private String date;
	    

		public long getDeliveryId() {
			return deliveryId;
		}

		public void setDeliveryId(long deliveryId) {
			this.deliveryId = deliveryId;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getVehicleNo() {
			return vehicleNo;
		}

		public void setVehicleNo(String vehicleNo) {
			this.vehicleNo = vehicleNo;
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "Delivery [deliveryId=" + deliveryId + ", Name=" + Name + ", address=" + address + ", phone=" + phone
					+ ", emailId=" + emailId + ", vehicleNo=" + vehicleNo + ", orderId=" + orderId + ", price=" + price
					+ ", date=" + date + "]";
		}
	

}
