package com.myecommerce.entity;



public class ProductEntity 
{
	private Long productId;
	private String productName;
	private String description;
	private Double priceperQty;
	private Integer avilableQty;
	private CategoryEntity categoryEntity;;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPriceperQty() {
		return priceperQty;
	}
	public void setPriceperQty(Double priceperQty) {
		this.priceperQty = priceperQty;
	}
	public Integer getAvilableQty() {
		return avilableQty;
	}
	public void setAvilableQty(Integer avilableQty) {
		this.avilableQty = avilableQty;
	}
	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}
	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	

}
