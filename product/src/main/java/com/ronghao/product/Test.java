package com.ronghao.product;

public class Test {
    public static void main(String[] args) {
        int a = 807;
        while (a % 10 != 0) {
            int carry = a % 10;
            a = a / 10;
            System.out.println(carry);
        }
    }
}