package com.example.demo_app.controller;

import com.example.demo_app.exception.LaptopException;
import com.example.demo_app.model.Laptop;
import com.example.demo_app.model.LaptopDTO;
import com.example.demo_app.repo.LaptopRepo;
import com.example.demo_app.service.Device;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.description.annotation.AnnotationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.util.comparator.Comparators;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RequestMapping(value = "/api")
@RestController
public class MainController {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("laptopService")
    private Device device;

    @GetMapping(value = "/msg")
    public String getMsg() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future =  device.sendNotificaation();
        //CompletableFuture<String> future1 =  device.sendNotificaation1();
        //CompletableFuture<String> future2 =  device.sendNotificaation2();

        return future.get();
    }

    @GetMapping(value = "/laptop")
    public List<LaptopDTO> getLaptops(@RequestParam(value = "pageNumber", required = false,defaultValue = "0") int pageNumber,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "2") int pageSize,
                                      @RequestParam(value = "sortBy",required = false,defaultValue = "laptopPrize") String sortBy) {
        List<Laptop> result = device.getAllLaptop(pageNumber,pageSize,Sort.by(Sort.Direction.DESC,sortBy));
        return result.stream()
                .map(laptop -> this.modelMapper.map(laptop,LaptopDTO.class))
                .toList();
    }

    @GetMapping(value = "/{laptopId}")
    public LaptopDTO getLaptop(@PathVariable("laptopId") int laptopId) {
        Laptop laptop = laptopRepo.findAll().stream().filter(laptopDB->laptopDB.getLaptopId() == laptopId).findFirst().orElse(null);
        if(laptop == null){
            throw new LaptopException("laptop with id:"+ laptopId +" not found.");
        }
        LaptopDTO laptopDTO = this.modelMapper.map(laptop,LaptopDTO.class);
        return laptopDTO;
    }

    @PostMapping(value = "/")
    public LaptopDTO saveLaptop(@RequestBody Laptop laptop){

        if(laptop.getLaptopName().isEmpty()){
            throw new LaptopException("laptop name should not empty");
        }
        Laptop laptopDB =  laptopRepo.save(laptop);
        LaptopDTO laptopDTO = this.modelMapper.map(laptopDB,LaptopDTO.class);
        return laptopDTO;

    }




}
