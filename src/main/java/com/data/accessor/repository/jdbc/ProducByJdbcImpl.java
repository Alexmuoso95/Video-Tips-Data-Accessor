package com.data.accessor.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.data.accessor.entity.Product;

@Repository
public class ProducByJdbcImpl {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//---------------------------WORK DONE -----------------------------------------------------------------------------------------------

	public Product getProductById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = ?", getRowMapper() , id);
	}
	//---------------------------WORK IN PROGRESS -----------------------------------------------------------------------------------------------
	public Product createProduct(Product product) {
		jdbcTemplate.update("INSERT INTO product (type,trade_mark,model,serial_number,clientId) VALUES (?,?,?,?,?)",
							product.getType(),
							product.getTradeMark(),
							product.getModel(),
							product.getSerialNumber() );
		
		Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()",Long.class);
		return this.getProductById(id);
	}
	//---------------------------WORK UNDEFINED -----------------------------------------------------------------------------------------------
	public List<Product> getProducts() {
		return jdbcTemplate.query("SELECT * FROM product", new ProductRowMap());
	}
	public Product updateProduct(Product product) {
		//jdbcTemplate.update("UPDATE product SET type =? ,trade_mark = ?, model= ?, serial_number= ? WHERE id = ?", product.getType(),product.getTradeMark(),product.getModel(),product.getSerialNumber(),product.getId());
		Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()",Long.class);
		return this.getProductById(id);
	}
	public String deleteProduct(Long id) {
		jdbcTemplate.update("DELETE FROM product WHERE id = ?",id);
		return "DELETED";
	}
	private RowMapper<Product> getRowMapper(){
		return new ProductRowMap();
	}
}
