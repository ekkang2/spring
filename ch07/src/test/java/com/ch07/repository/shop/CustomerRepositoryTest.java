package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

    public void selectCustomer() {

    }

    public void searchCustomer() {
    }


    public void searchKeyword() {
    }
}
