package com.OnlineFashionStore.customer.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
	
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Inventoryid")
    private long inventoryid;


 

	public void setInventoryid(long inventoryid) {
		this.inventoryid = inventoryid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return ItemCategory;
	}

	public void setItemCategory(String itemCategory) {
		ItemCategory = itemCategory;
	}

	public String getItemType() {
		return ItemType;
	}

	public void setItemType(String itemType) {
		ItemType = itemType;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	@Column(name="ItemName")
    private String itemName;

    @Column(name="ItemCategory")
    private String ItemCategory;

    @Column(name="ItemType")
    private String ItemType;
      
    @Column(name="Size")
    private String Size;
    
    @Column(name="Price")
    private String Price;
    
    @Column(name="Quantity")
    private String Quantity;


	public long getInventoryid() {
		// TODO Auto-generated method stub
		return inventoryid;
	}




	

    

}
