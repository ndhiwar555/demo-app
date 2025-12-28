package com.example.demo_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer laptopId;

    private String laptopName;

    private double laptopPrize;

    public Laptop(String laptopName, double laptopPrize) {
        this.laptopName = laptopName;
        this.laptopPrize = laptopPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Laptop laptop)) return false;
        return Double.compare(laptopPrize, laptop.laptopPrize) == 0 && Objects.equals(laptopId, laptop.laptopId) && Objects.equals(laptopName, laptop.laptopName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laptopId, laptopName, laptopPrize);
    }
}
