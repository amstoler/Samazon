package com.example.demo.Repositories;

import com.example.demo.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
