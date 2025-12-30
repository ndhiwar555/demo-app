package com.example.demo_app.repo;

import com.example.demo_app.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Integer>, ListPagingAndSortingRepository<Laptop,Integer> {
}
