package com.example.jparelation.controller;

import com.example.jparelation.dto.OrderRequest;
import com.example.jparelation.dto.OrderResponse;
import com.example.jparelation.model.Customer;
import com.example.jparelation.model.Product;
import com.example.jparelation.repository.CustomerRepository;
import com.example.jparelation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerrepository;
    @Autowired
    private ProductRepository productrepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerrepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrder(){
        return customerrepository.findAll();
    }

    @GetMapping("/findInfo")
    public List<OrderResponse> getJoinInformation()
    {
        return customerrepository.getJoinInformation();
    }
}
