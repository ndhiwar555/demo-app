package com.example.demo_app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LaptopException extends RuntimeException{

    public LaptopException(String msg){
        super(msg);
    }


}
