package com.data.accessor.repository.jpahibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.accessor.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
