package com.ch07.entity.shop;

import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "shop_order")
public class Order {

    private int orderId;
    private int orderPrice;
    private int orderStatus;
    private LocalDateTime orderDate;

    private Customer customer;

}
