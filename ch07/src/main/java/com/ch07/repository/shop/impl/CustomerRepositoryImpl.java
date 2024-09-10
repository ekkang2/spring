package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// CustomerRepository 확장 인터페이스 구현 클래스
@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    
    // Q도메인 클래스 선언
    private QCustomer qCustomer = QCustomer.customer;

    @Override
    public List<Customer> selectCustomers() {
        // select * from customer
        return queryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();
    }

    @Override
    public Customer selectCustomer(String custId) {
        return queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
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
