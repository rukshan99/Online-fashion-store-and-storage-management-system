package com.OnlineFashionStore.customer.jpa;

import javax.persistence.*;



@Entity
public class Product{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private long  product_id;
	
	@Column(name="product_name")
    private String product_name;

    @Column(name="Product_code")
    private String productCode;

    @Column(name="manu_date")
    private String manu_date;
      
    @Column(name="category")
    private String category;
    
    @Column(name="type")
    private String type;
    
    @Column(name="size")
    private String size;
    
    @Column(name="colour")
    private String colour;
    
    @Column(name="material")
    private String material;
    
    @Column(name="URcode")
    private String URcode;
    
    
  //getters ad setters

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_code() {
		return productCode;
	}

	public void setProduct_code(String product_code) {
		this.productCode = product_code;
	}

	public String getManu_date() {
		return manu_date;
	}

	public void setManu_date(String manu_date) {
		this.manu_date = manu_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getURcode() {
		return URcode;
	}

	public void setURcode(String uRcode) {
		URcode = uRcode;
	}
    
}


