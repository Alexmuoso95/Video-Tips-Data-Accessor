package com.data.accessor.controller.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.data.accessor.controller.definition.ProductController;
import com.data.accessor.entity.Product;
import com.data.accessor.service.definition.ProductService;

public class ProductControllerImpl implements ProductController{

	@Autowired
	ProductService service;
	//-------------------IN PROGRESS------------------------------------------------------------------

	@PostMapping()
	public ResponseEntity<Product> insertProduct(@RequestBody Product product){
		return new ResponseEntity<> (service.createProduct(product),HttpStatus.CREATED);
	}
	//-------------------UNDEIFNED ------------------------------------------------------------------
	@GetMapping()
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<> (service.getProducts(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id){
		return new ResponseEntity<> (service.getProductById(id),HttpStatus.OK);
	}
	@PutMapping()
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		return new ResponseEntity<> (service.updateProduct(product),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		return new ResponseEntity<> (service.deleteProduct(id),HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Product> getProductByClientId(Long id) {
		return null;
	}
	
}
