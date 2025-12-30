package com.example.demo_app.service;

import com.example.demo_app.model.Laptop;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service("mobileService")
public class MobileService implements Device{

    @Override
    public String saveDetails() {
        return "Mobile service called..";
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> sendNotificaation() {
        try {
            for(int i=1;i<11;i++){
                Thread.sleep(100); // Simulate delay
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent via mobile service ");
        return CompletableFuture.completedFuture("Email sent successfully via mobile service");
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> sendNotificaation1() {
        try {
            for(int i=11;i<21;i++){
                Thread.sleep(100); // Simulate delay
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent via mobile service-1 ");
        return CompletableFuture.completedFuture("Email sent successfully via mobile service");
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> sendNotificaation2() {
        try {
            for(int i=21;i<31;i++){
                Thread.sleep(100); // Simulate delay
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent via mobile service-2");
        return CompletableFuture.completedFuture("Email sent successfully via mobile service");
    }

    @Override
    public List<Laptop> getAllLaptop(int page, int size, Sort by) {
        return List.of();
    }
}
