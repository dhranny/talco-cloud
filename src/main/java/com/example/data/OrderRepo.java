package com.example.data;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Order;

public interface OrderRepo extends CrudRepository<Order, Long>{

}
