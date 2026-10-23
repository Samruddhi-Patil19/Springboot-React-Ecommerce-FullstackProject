package com.ecom.productcatalog.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
				
		//clear all existing data	
		productRepository.deleteAll();
		categoryRepository.deleteAll();
		
		//cretae categories
		Category electronics = new Category();
		electronics.setName("Electronics");
		
		Category clothing = new Category();
		clothing.setName("Clothing");
		
		Category home = new Category();
		home.setName("Home and Kitchen");
		
		
		categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));
		
		// Create products
		Product phone =new Product();
		phone.setName("SmartPhone");
		phone.setDescription("Latest mode smartphone with amazing features");
		phone.setImageUrl("https://placehold.co/600x400");
		phone.setPrice(60000.00);
		phone.setCategory(electronics);
		
		Product laptop =new Product();
		laptop.setName("Laptop");
		laptop.setDescription("High performance laptop for work and play.");
		laptop.setImageUrl("https://placehold.co/600x400");
		laptop.setPrice(90000.00);
		laptop.setCategory(electronics);
		
		Product jacket =new Product();
		jacket.setName("Winter Jacket");
		jacket.setDescription("Warm and cozy jacket for winter.");
		jacket.setImageUrl("https://placehold.co/600x400");
		jacket.setPrice(5000.00);
		jacket.setCategory(clothing);
		
		Product blender =new Product();
		blender.setName("Blender");
		blender.setDescription("High speed blender for smoothies and more.");
		blender.setImageUrl("https://placehold.co/600x400");
		blender.setPrice(2000.00);
		blender.setCategory(home);
		
		productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));
	}

}





















