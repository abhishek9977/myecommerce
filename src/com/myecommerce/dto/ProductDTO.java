package com.myecommerce.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5361505409093251787L;
	private Long productId;
	private String productName;
	private String description;
	private Double priceperQty;
	private Integer avilableQty;
	private CategoryDTO categoryDTO;
	
	
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
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	
	

}
