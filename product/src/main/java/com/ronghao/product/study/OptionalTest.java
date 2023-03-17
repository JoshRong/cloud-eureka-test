package com.ronghao.product.study;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional=Optional.of("jame");
        optional.ifPresent(s -> System.out.println(s));
    }
}