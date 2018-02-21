package com.example.demo.Repositories;

import com.example.demo.Model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingRepo extends CrudRepository<ShoppingCart,Long> {
}
