package com.example.librarydb;

import com.example.librarydb.product.ProductRepo;
import com.example.librarydb.product.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication(scanBasePackages = {
		"com.example.librarydb"
})
@RestController
@RequestMapping("/product")
public class RedisExample {


	@Autowired
	ProductRepo productRepo;


	@PostMapping("/addProduct")
	public product add(@RequestBody product p){
		return productRepo.save(p);
	}

	@GetMapping("/getAll")
	public List<Object> find(){
		return productRepo.findAll();
	}


	public static void main(String[] args) {
		SpringApplication.run(RedisExample.class, args);
	}

}
