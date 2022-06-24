package com.myecommerce.service;
import java.util.List;

import com.myecommerce.dto.ProductDTO;
import com.myecommerce.exception.BusinessException;



public interface ProductService 
{
	public ProductDTO addProduct(ProductDTO productDTO) throws BusinessException ;
	public ProductDTO getProduct(Long productID);
	public List<ProductDTO> getAllProduct();
	public ProductDTO updateProduct(Long productID,Double newPrice);
    public List<ProductDTO> searchProductByName(String name);
    public ProductDTO deleteProduct(Long productID);
    
}
