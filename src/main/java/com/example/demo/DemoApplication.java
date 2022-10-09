package com.example.demo;

import com.cloudinary.Cloudinary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		System.out.println(ctx.getBean(Cloudinary.class));
	}

//	@Bean
//	public Cloudinary cloudinaryConfig() {
//		Cloudinary cloudinary = null;
//		Map config = new HashMap();
//		config.put("cloud_name", "dd8b69mls");
//		config.put("api_key", "174989952789425");
//		config.put("api_secret", "XvMvoZetwuEpy0W-6c2ZBW8oluU");
//		cloudinary = new Cloudinary(config);
//		return cloudinary;
//	}


}
