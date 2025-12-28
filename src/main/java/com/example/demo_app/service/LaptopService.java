package com.example.demo_app.service;

import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service("laptopService")
public class LaptopService implements Device {

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
}
