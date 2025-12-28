package com.example.demo_app.service;

import java.util.concurrent.CompletableFuture;

public interface Device {
    String saveDetails();

    CompletableFuture<String> sendNotificaation();
    CompletableFuture<String> sendNotificaation1();
    CompletableFuture<String> sendNotificaation2();
}
