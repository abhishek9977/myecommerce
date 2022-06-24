package com.myecommerce.repository;

import java.util.List;

import com.myecommerce.dto.ProductDTO;
import com.myecommerce.entity.ProductEntity;



public interface ProductRepository 
{

	public ProductEntity addProduct(ProductEntity productEntity) ;
	public ProductEntity getProduct(Long productID);
	public List<ProductEntity> getAllProduct();
	public ProductEntity updateProduct(Long productID,Double newPrice);
    public List<ProductEntity> searchProductByName(String name);
    public ProductEntity deleteProduct(Long productID);
	

}
