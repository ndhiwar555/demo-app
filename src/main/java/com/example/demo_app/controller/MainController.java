package com.example.demo_app.controller;

import com.example.demo_app.exception.LaptopException;
import com.example.demo_app.model.Laptop;
import com.example.demo_app.repo.LaptopRepo;
import com.example.demo_app.service.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RequestMapping(value = "/api")
@RestController
public class MainController {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private Device device;

    @GetMapping(value = "/msg")
    public String getMsg() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future =  device.sendNotificaation();
        //CompletableFuture<String> future1 =  device.sendNotificaation1();
        //CompletableFuture<String> future2 =  device.sendNotificaation2();

        return future.get();
    }

    @GetMapping(value = "/")
    public List<Laptop> getLaptops() {
        return laptopRepo.findAll().stream().sorted(Comparator.comparing(Laptop::getLaptopPrize).reversed()).toList();
    }

    @GetMapping(value = "/{laptopId}")
    public Laptop getLaptop(@PathVariable("laptopId") int laptopId) {
        Laptop laptop = laptopRepo.findAll().stream().filter(laptopDB->laptopDB.getLaptopId() == laptopId).findFirst().orElse(null);
        if(laptop == null){
            throw new LaptopException("laptop with id:"+ laptopId +" not found.");
        }
        return laptop;
    }

    @PostMapping(value = "/")
    public Laptop saveLaptop(@RequestBody Laptop laptop){

        if(laptop.getLaptopName().isEmpty()){
            throw new LaptopException("laptop name should not empty");
        }

        return laptopRepo.save(laptop);

    }
}
