package com.data.accessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class VideoTipsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VideoTipsApplication.class, args);
	}
	public static void setDatabaseProducts() {
	}
}
