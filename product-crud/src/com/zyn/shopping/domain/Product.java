package com.zyn.shopping.domain;

import java.math.BigDecimal;
public class Product {
	private Long id;
	private String productName;
	private String brand;
	private String supplier;
	private BigDecimal salePrice;
	private BigDecimal costPrice;
	private double cutoff;
	ProductDir dir;
	public void setId(Long id) {
		this.id = id;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	public void setCutoff(double cutoff) {
		this.cutoff = cutoff;
	}
	public void setDir(ProductDir dir) {
		this.dir = dir;
	}
	public Long getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public String getBrand() {
		return brand;
	}
	public String getSupplier() {
		return supplier;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public double getCutoff() {
		return cutoff;
	}
	public ProductDir getDir() {
		return dir;
	}
	
	
}
