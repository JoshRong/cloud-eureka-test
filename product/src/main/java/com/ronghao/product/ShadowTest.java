package com.ronghao.product;

public class ShadowTest {
    public int x = 0;

    class FirstLeve {
        public int x = 1;

        void methodFirstLevel(int x) {
            System.out.println("x=" + x);
            System.out.println("this.x=" + this.x);
            System.out.println("ShadowTest.this.x" + ShadowTest.this.x);
        }
    }

    public static void main(String[] args) {
        ShadowTest shadowTest=new ShadowTest();
        ShadowTest.FirstLeve f1=shadowTest.new FirstLeve();
        f1.methodFirstLevel(23);
    }
}