package com.example.demo_app.service;

import com.example.demo_app.model.Laptop;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Device {
    String saveDetails();

    CompletableFuture<String> sendNotificaation();
    CompletableFuture<String> sendNotificaation1();
    CompletableFuture<String> sendNotificaation2();
    List<Laptop> getAllLaptop(int page, int size, Sort by);
}
