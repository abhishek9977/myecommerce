package com.myecommerce.converter;

import com.myecommerce.dto.CategoryDTO;
import com.myecommerce.dto.ProductDTO;
import com.myecommerce.entity.CategoryEntity;
import com.myecommerce.entity.ProductEntity;

public class ProductConverter 
{
	public static ProductEntity convertProductDtotoProductEntity(ProductDTO productDTO )
	{
		ProductEntity pe=new ProductEntity();
		pe.setProductName(productDTO.getProductName());
		pe.setAvilableQty(productDTO.getAvilableQty());
		pe.setDescription(productDTO.getDescription());
		pe.setPriceperQty(productDTO.getPriceperQty());
		
		CategoryEntity ce=new CategoryEntity();
		ce.setCategoryId(productDTO.getCategoryDTO().getCategoryId());
		pe.setCategoryEntity(ce);
		
		return pe;
	}
	
	public static ProductDTO convertProductEntitytoProducDto(ProductEntity pe)
	{
		ProductDTO productDTO=new ProductDTO();
		productDTO.setProductId(pe.getProductId());
        productDTO.setProductName(pe.getProductName());
		productDTO.setAvilableQty(pe.getAvilableQty());
		productDTO.setDescription(pe.getDescription());
		productDTO.setPriceperQty(pe.getPriceperQty());
		
		CategoryDTO ce=new CategoryDTO();
		ce.setCategoryId(pe.getCategoryEntity().getCategoryId());
		ce.setCategoryName(pe.getCategoryEntity().getCategoryName());
		ce.setDescription(pe.getCategoryEntity().getDescription());
		productDTO.setCategoryDTO(ce);
		
		return productDTO;
	}


}
