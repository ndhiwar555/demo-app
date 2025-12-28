package com.example.demo_app;

import com.example.demo_app.model.Laptop;
import com.example.demo_app.repo.LaptopRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

    @Autowired
    private LaptopRepo laptopRepo;

    @PostConstruct
    public void init() {
        laptopRepo.save(new Laptop("HP",12345.098));
        laptopRepo.save(new Laptop("Apple",90000.500));
        laptopRepo.save(new Laptop("Lenovo",10000.500));
    }
}
