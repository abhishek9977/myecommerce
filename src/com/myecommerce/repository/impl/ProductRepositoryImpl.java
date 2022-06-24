package com.myecommerce.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myecommerce.configuration.DBConfiguration;
import com.myecommerce.entity.CategoryEntity;
import com.myecommerce.entity.ProductEntity;
import com.myecommerce.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public ProductEntity addProduct(ProductEntity productEntity) {
		Connection connection = DBConfiguration.getConnection();
		String sql = "Insert into product(product_name,description,price_per_qty,available_qty,category_id_fk )values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, productEntity.getProductName());
			stmt.setString(2, productEntity.getDescription());
			stmt.setDouble(3, productEntity.getPriceperQty());
			stmt.setInt(4, productEntity.getAvilableQty());
			stmt.setLong(5, productEntity.getCategoryEntity().getCategoryId());

			int rowinserted = stmt.executeUpdate();
			if (rowinserted > 0) {
				System.out.println("new product is inserted");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productEntity;
	}

	@Override
	public ProductEntity getProduct(Long productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> getAllProduct() {
		Connection connection = DBConfiguration.getConnection();
		List<ProductEntity> productList = new ArrayList<>();

		try {
			String sql = "select p.product_id,p.product_name,p.description,p.price_per_qty,p.available_qty,c.category_name from product p ,category c where p.category_id_fk=c.category_id;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Long productId = rs.getLong(1);

				String productname = rs.getString("product_name");
				String description = rs.getString("description");

				Double productprice = rs.getDouble("price_per_qty");
				Integer productava = rs.getInt("available_qty");

				String categoryname = rs.getString("category_name");

				ProductEntity pe = new ProductEntity();
				pe.setProductId(productId);
				pe.setProductName(productname);
				pe.setAvilableQty(productava);
				pe.setDescription(description);
				pe.setPriceperQty(productprice);

				CategoryEntity ce = new CategoryEntity();
				ce.setCategoryName(categoryname);
				pe.setCategoryEntity(ce);

				productList.add(pe);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return productList;
	}

	@Override
	public ProductEntity updateProduct(Long productID, Double newPrice) {
		Connection connection = DBConfiguration.getConnection();
		ProductEntity pe = null;

		try {
			String sql = "update product set price_per_qty=? where product_id=?;\r\n";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, newPrice);
			stmt.setLong(2, productID);

			int uprow = stmt.executeUpdate();
			if (uprow > 0) {
				System.out.println("*******The user was updated sucessfully********");
			}

			sql = "select p.product_id,p.product_name,p.description,p.price_per_qty,p.available_qty,c.category_name from product p ,category c where p.category_id_fk=c.category_id and p.product_id="
					+ productID;
			stmt = connection.prepareStatement(sql);
			// stmt.setLong(1,productID);

			ResultSet rs = stmt.executeQuery(sql);
			pe = new ProductEntity();

			while (rs.next()) {
				Long productId = rs.getLong(1);

				String productname = rs.getString("product_name");
				String description = rs.getString("description");

				Double productprice = rs.getDouble("price_per_qty");
				Integer productava = rs.getInt("available_qty");

				String categoryname = rs.getString("category_name");

				pe.setProductId(productId);
				pe.setProductName(productname);
				pe.setAvilableQty(productava);
				pe.setDescription(description);
				pe.setPriceperQty(productprice);

				CategoryEntity ce = new CategoryEntity();
				ce.setCategoryName(categoryname);
				pe.setCategoryEntity(ce);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pe;
	}

	@Override
	public List<ProductEntity> searchProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity deleteProduct(Long productID) {
		Connection connection = DBConfiguration.getConnection();
		ProductEntity pe = null;

		try {

			String sql = "select p.product_id,p.product_name,p.description,p.price_per_qty,p.available_qty,c.category_name from product p ,category c where p.category_id_fk=c.category_id and p.product_id="
					+ productID;
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
			stmt=connection.prepareStatement(sql);
			pe = new ProductEntity();

			while (rs.next()) {
				Long productId = rs.getLong(1);

				String productname = rs.getString("product_name");
				String description = rs.getString("description");

				Double productprice = rs.getDouble("price_per_qty");
				Integer productava = rs.getInt("available_qty");

				String categoryname = rs.getString("category_name");

				pe.setProductId(productId);
				pe.setProductName(productname);
				pe.setAvilableQty(productava);
				pe.setDescription(description);
				pe.setPriceperQty(productprice);

				CategoryEntity ce = new CategoryEntity();
				ce.setCategoryName(categoryname);
				pe.setCategoryEntity(ce);

			}

			if (pe.getProductId() != null) {
				
				System.out.println("product id"+productID);
				sql = "delete from product where product_id=?;";
				stmt = connection.prepareStatement(sql);
				stmt.setLong(1, productID);

				int rowde = stmt.executeUpdate();
				if (rowde > 0) {
					System.out.println("*******product deleted*******");
				} else {
					System.out.println("********not found********");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pe;
	}

}
