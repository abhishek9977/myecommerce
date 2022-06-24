package com.myecommerce.service.client;

import java.util.List;
import java.util.Scanner;

import com.myecommerce.dto.CategoryDTO;
import com.myecommerce.dto.ProductDTO;
import com.myecommerce.exception.BusinessException;
import com.myecommerce.service.ProductService;
import com.myecommerce.service.impl.ProductServiceImpl;

public class ProductMain {

	public static void main(String[] args) 
	{
		//create reference of interface and object of implementing class
		//dynamic ploymorphism
		ProductService prodcutService= new ProductServiceImpl();
		while(true)
		{
			createMenu();
			Scanner sc=new Scanner(System.in);
			Integer ch=sc.nextInt();
			if(ch.equals(1))
			{
			addProduct(prodcutService);
			}
			else if(ch.equals(2))
			{
			getAllProduct(prodcutService);
			}
			else if(ch.equals(3))
			{
			getProduct(prodcutService);
			}
			else if(ch.equals(4))
			{
			updateProduct(prodcutService);
			}
			else if(ch.equals(5))
			{
				searchProductByName(prodcutService);
			}
			else if(ch.equals(6))
			{
				deleteProduct(prodcutService);
			}
			else
			{
				System.out.println("application exit");
				System.exit(0);
			}

		}
		
	}
	
	

	public static void createMenu()
	{
		System.out.println("enter 1 for add product");
		System.out.println("enter 2 for getting all product");
		System.out.println("enter 3 to a product details");
		System.out.println("Enter 4 for updating the product");
		System.out.println("enter 5 for searching the product");
		System.out.println("enter 6 for deleting element from list");
		System.out.println("enter 100 to exit programme");
	}
	private static void deleteProduct(ProductService productService)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product id for delete:");
		Long productID=sc.nextLong();
		ProductDTO ddto=productService.deleteProduct(productID);
		
		if(ddto!=null)
		{
			System.out.println("*********product deleted "+productID+"**********");
			System.out.println("product name:"+ddto.getProductName());
			System.out.println("product ava:"+ddto.getAvilableQty());
			System.out.println("deleted product price:"+ddto.getPriceperQty());
			System.out.println("product category:"+ddto.getCategoryDTO().getCategoryName());
	  
			
		}
		else
		{
			System.out.println("no product found");
		}
		
	}
	private static void searchProductByName(ProductService productService)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a product name that you want to search");
		String Name=sc.nextLine();
         List<ProductDTO> dt=productService.searchProductByName(Name);
		
		if(dt.size()>0)
		{
			for(ProductDTO dto:dt)
			{
			System.out.println("product name:"+((ProductDTO) dto).getProductName());
			System.out.println("product ava:"+((ProductDTO) dto).getAvilableQty());
			System.out.println("product price:"+((ProductDTO) dto).getPriceperQty());
			System.out.println("product category:"+((ProductDTO) dto).getCategoryDTO().getCategoryName());
			System.out.println("*******************************");
			}
		}
		else
		{
			System.out.println("product not found");
		}
		
		
	}
	
	private static void updateProduct(ProductService prodcutService) 
	{
		getAllProduct(prodcutService);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product id for update");
		Long productID=sc.nextLong();
		System.out.println("enter a new price");
		Double newPrice=sc.nextDouble();
		ProductDTO dto=prodcutService.updateProduct(productID, newPrice);
		if(null!=dto)
		{
			System.out.println("*********product found "+productID+"**********");
			System.out.println("product name:"+dto.getProductName());
			System.out.println("product ava:"+dto.getAvilableQty());
			System.out.println("updated product price:"+dto.getPriceperQty());
			System.out.println("product category:"+dto.getCategoryDTO().getCategoryName());
	  
		}
		else
		{
			System.out.println("product not found");
		}
		
		
		
	}

	private static void getProduct(ProductService prodcutService) 
	{
		getAllProduct(prodcutService);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product id for details");
		Long productId=sc.nextLong();
		ProductDTO dto=prodcutService.getProduct(productId);
		
		if(null!=dto)
		{
			System.out.println("*********product found "+productId+"**********");
			System.out.println("product name:"+dto.getProductName());
			System.out.println("product ava:"+dto.getAvilableQty());
			System.out.println("product price:"+dto.getPriceperQty());
			System.out.println("product category:"+dto.getCategoryDTO().getCategoryName());
	  
		}
		else
		{
			System.out.println("product not found");
		}
		
	}
	
	private static void getAllProduct(ProductService productservice)
	{
		List<ProductDTO> product=productservice.getAllProduct();
//		try {
//		for(Integer count=0;count<product.size();count++)
//		{
//		System.out.println("product name:"+product.get(count).getProductName());
//		System.out.println("product ava:"+product.get(count).getAvilableQty());
//		System.out.println("product price"+product.get(count).getPriceperQty());
//		}
//		}
//		catch(Exception e)
//		{
//			System.out.println("error occured");
//		}
		System.out.println("*******product displaying*******");
		if(null != product)
		{
		
		for(ProductDTO dto:product)
		{
			System.out.println("product id:"+dto.getProductId());
			System.out.println("product name:"+dto.getProductName());
			System.out.println("product ava:"+dto.getAvilableQty());
			System.out.println("product price:"+dto.getPriceperQty());
			System.out.println("product category:"+dto.getCategoryDTO().getCategoryName());
	  
			
		}
	}
		
		
	}
	public static void addProduct(ProductService prodcutService)
	{
		Scanner sc =new Scanner(System.in);
		ProductDTO dto=new ProductDTO();
		dto.setProductId(System.currentTimeMillis());
		System.out.println("enter product name:");
		dto.setProductName(sc.nextLine());
		System.out.println("enter product avilability:");
		dto.setAvilableQty(sc.nextInt());
		System.out.println("enter product des:");
		dto.setDescription(sc.next());
		System.out.println("enter a product price:");
		dto.setPriceperQty(sc.nextDouble());
		sc.nextLine();
	    System.out.println("enter product categoryId:");
		CategoryDTO cdto=new CategoryDTO();
		cdto.setCategoryId(sc.nextLong());
		
		
	
		dto.setCategoryDTO(cdto);
	
		ProductDTO productDto=null;
		
			try {
				 productDto=prodcutService.addProduct(dto);
			} catch (BusinessException e) {
				System.out.println(e.getErroCode());
				System.out.println(e.getErroMsg());
			}
		
		if(null != productDto)
		{
		System.out.println("********product add sucessfully********");
		}
	}

}
