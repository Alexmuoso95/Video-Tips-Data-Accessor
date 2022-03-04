package com.data.accessor.controller.definition;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.accessor.entity.Product;

@RestController
@RequestMapping("v1/products")
public interface ProductController {
	@PostMapping()
	public ResponseEntity<Product> insertProduct(@RequestBody Product product);
	@GetMapping()
	public ResponseEntity<List<Product>> getProducts();
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductByClientId(@PathVariable Long id);
	@PutMapping()
	public ResponseEntity<Product> updateProduct(@RequestBody Product product);
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id);
}
