package com.data.accessor.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.accessor.entity.Product;
import com.data.accessor.repository.jdbc.ProducByJdbcImpl;
import com.data.accessor.repository.jpahibernate.ProductRepository;
import com.data.accessor.service.definition.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProducByJdbcImpl producByJdbcImpl;
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product getProductById(Long id) {
		return producByJdbcImpl.getProductById(id);
	}

	@Override
	public Product createProduct(Product product) {
		return producByJdbcImpl.createProduct(product);
	}
	@Override
	public List<Product>  getProducts() {
		//JDBC
		return producByJdbcImpl.getProducts();
	}
	@Override
	public Product updateProduct(Product product) {
		return producByJdbcImpl.updateProduct(product);
	}
	@Override
	public String deleteProduct(Long id) {
		return producByJdbcImpl.deleteProduct(id);
	}
	
}
