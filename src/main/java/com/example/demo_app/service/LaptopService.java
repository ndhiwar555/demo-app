package com.example.demo_app.service;

import com.example.demo_app.model.Laptop;
import com.example.demo_app.repo.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service("laptopService")
public class LaptopService implements Device {

    @Autowired
    LaptopRepo laptopRepo;

    @Override
    public String saveDetails() {
        return "Laptop service called..";
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> sendNotificaation() {
        try {
            for(int i=1;i<5;i++){
                Thread.sleep(50); // Simulate delay
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent via laptop service ");
        return CompletableFuture.completedFuture("Email sent successfully via laptop service");
    }

    @Override
    public CompletableFuture<String> sendNotificaation1() {
        return null;
    }

    @Override
    public CompletableFuture<String> sendNotificaation2() {
        return null;
    }

    public List<Laptop> getAllLaptop(int page, int size, Sort sort) {
        return laptopRepo.findAll(PageRequest.of(page, size, sort)).toList();
    }
}
