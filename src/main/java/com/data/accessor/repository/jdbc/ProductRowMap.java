package com.data.accessor.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.data.accessor.entity.Product;


@Component
public class ProductRowMap implements RowMapper<Product>{
	//No thread safe
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setType(rs.getString("type"));
		product.setTradeMark(rs.getString("trade_mark"));
		product.setModel(rs.getString("model"));
		product.setSerialNumber(rs.getString("serial_number"));
		return product;
	}

}
