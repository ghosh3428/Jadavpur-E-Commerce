package com.niit.Jadavpur_Backend.modal;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Niit_Jadavpur_Product")
public class Product 
{
	
	@Id
	private int id;
	
	private String code;
	
	private String name;

	private String brand;
	
	private String description;
	
	@Column(name = "unit_price")
	private double unitPrice;

	private int quantity;
	
	@JsonIgnore
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@JsonIgnore
	@Column(name = "supplier_id")
	private int supplierId;
	

	public Product() 
	{	
		code = "PRD" + UUID.randomUUID().toString().substring(24);
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

}