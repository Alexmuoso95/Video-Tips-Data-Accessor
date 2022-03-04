package com.data.accessor.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;


import com.data.accessor.entity.Product;
import com.data.accessor.repository.jpahibernate.ProductRepository;


@DataJpaTest
//@SpringBootTest
@ComponentScan(basePackages = {"com.data.accessor"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql(statements = "INSERT INTO videotips.product VALUES ('TV','SAMSUNG','123456789','123456789');") 
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;
	
	@Test
	@Order(1)
	@Commit
	//@Rollback(true)
	void saveProduct() {
		Product product = new Product();
		product.setType("TV");
		product.setTradeMark("SAMSUNG");
		product.setModel("123456789");
		product.setSerialNumber("123456789");
		Product productSaved = repository.save(product);
		assertNotNull(productSaved.getId());
	}
	@Test
	@Order(2)
	void noZeroRecords() {
		assertTrue(repository.count()>0);
	}
}
