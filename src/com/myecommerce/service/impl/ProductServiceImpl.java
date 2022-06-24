package com.myecommerce.service.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.myecommerce.converter.ProductConverter;
import com.myecommerce.dto.ProductDTO;
import com.myecommerce.entity.CategoryEntity;
import com.myecommerce.entity.ProductEntity;
import com.myecommerce.exception.BusinessException;
import com.myecommerce.repository.ProductRepository;
import com.myecommerce.repository.impl.ProductRepositoryImpl;
import com.myecommerce.service.ProductService;

/***
 * 
 * @author myecommerce pvt.ltd
 * class name:productserviceimpl
 * functionality:this class helps to provide functionality like adding new product,
 *               getting all product,searching , update.
 *
 */

public class ProductServiceImpl implements ProductService{

    private List<ProductDTO> productlist=new ArrayList<>();
    private ProductRepository productRepository;
    
    public ProductServiceImpl()
    {
    	this.productRepository=new ProductRepositoryImpl();
    }
    
    /***
     * method name:addProduct
     * return type:ProductDTO
     * parameter:productDTO
     * description:for adding new product
     */
    
    
    
	@Override
	public ProductDTO addProduct(ProductDTO productDTO) throws BusinessException {
		/*below lines add product to existing product list*/
		for(ProductDTO dto:productlist)
		{
			if(dto.getProductName().equalsIgnoreCase(productDTO.getProductName()))
			{
				BusinessException be=new BusinessException();
				be.setErroCode("fy-01");
				be.setErroMsg("dont error same product");
				throw be;
			}
			
		}
		ProductEntity pe=ProductConverter.convertProductDtotoProductEntity(productDTO);
		pe=this.productRepository.addProduct(pe);
		//DataSerializer.serializeProduct(productDTO);
		//productlist.add(productDTO);
		productDTO = ProductConverter.convertProductEntitytoProducDto(pe);
		
		return productDTO;
	}

	@Override
	public ProductDTO getProduct(Long productID) {
		for(ProductDTO dto:productlist)
		{
			if(dto.getProductId().equals(productID))
			{
				return dto;
			}
			
		}
		return null;
	}

	@Override
	public List<ProductDTO> getAllProduct() 
	{
		List<ProductEntity> pe=this.productRepository.getAllProduct();
		List<ProductDTO>  pdl= new ArrayList<>();
		for(ProductEntity p:pe)
		{
		 ProductDTO pd=ProductConverter.convertProductEntitytoProducDto(p);
		 pdl.add(pd);
		}
		return pdl;
	}

	@Override
	public List<ProductDTO> searchProductByName(String name) 
	{
		List<ProductDTO> found=new ArrayList<>();

		for(ProductDTO dto:this.productlist)
		{
			if(dto.getProductName().contains(name))//we use contains for all matching product
			{
				found.add(dto);
			}
		}
		return found;
	}

	//@Override
	public ProductDTO updateProductnonDB(Long productID,Double newPrice)
	{
		ProductDTO dto=this.getProduct(productID);
		if(null !=dto)
		{
			dto.setPriceperQty(newPrice);
			//find the product with matching productid and remove from the list
			for(Integer i=0;i<productlist.size();i++)
			{
				if(productlist.get(i).getProductId().equals(productID))
						{
					       
					        //replace our current product with replace 
					        productlist.set(i,dto);
					        break;
						}
			}
			return dto;
		}
		
		return null;
	}
	@Override
	public ProductDTO updateProduct(Long productID,Double newPrice)
	{
		ProductEntity pe=this.productRepository.updateProduct(productID, newPrice);
		ProductDTO dto=ProductConverter.convertProductEntitytoProducDto(pe);
			return dto;
		
		
		
	}

	//@Override
	public ProductDTO deleteProductbynonDB(Long productID) 
	{
		/*
		 * Iterator<ProductDTO> dto=productlist.iterator(); ProductDTO dt=null;
		 * while(dto.hasNext()) { dt=dto.next(); if(dt.getProductId().equals(productID))
		 * { dto.remove(); } } return dt;
		 */
		ProductDTO pd=null;
		List<ProductDTO> newList=new ArrayList<>();
		for(ProductDTO dto:productlist)
		{
			if(dto.getProductId().equals(productID))
			{
				pd=dto;
			}
			else
			{
				newList.add(dto);
			}
		}
		productlist.clear();//reset all the older list
		productlist.addAll(newList);//add new list to existing object
		return pd;
	}
	
	@Override
	public ProductDTO deleteProduct(Long productID) 
	{
		
		

		ProductEntity pe=this.productRepository.deleteProduct(productID);
		ProductDTO dto=ProductConverter.convertProductEntitytoProducDto(pe);
		return dto;
     }

}