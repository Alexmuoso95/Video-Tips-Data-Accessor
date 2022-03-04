package com.data.accessor.service.definition;

import java.util.List;

import com.data.accessor.entity.Product;

public interface ProductService {
	Product getProductById(Long id);
	Product createProduct(Product product);
	List<Product>  getProducts();
	Product updateProduct(Product product);
	String deleteProduct(Long id);
}
