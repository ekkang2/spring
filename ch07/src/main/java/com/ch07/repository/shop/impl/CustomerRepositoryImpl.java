package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;

import java.util.List;

// CustomerRepository 확장 인터페이스 정의
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Override
    public List<Customer> selectCustomers() {
        return List.of();
    }

    @Override
    public Customer selectCustomer(String custId) {
        return null;
    }

    @Override
    public List<Customer> searchCustomer(String nameCondition, int ageCondition) {
        return List.of();
    }

    @Override
    public List<Customer> searchKeyword(String keyword) {
        return List.of();
    }
}
