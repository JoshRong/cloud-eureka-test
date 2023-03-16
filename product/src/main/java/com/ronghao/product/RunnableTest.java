package com.ronghao.product;

import java.util.Comparator;

public class RunnableTest {
    @FunctionalInterface
    public interface WorkerInterface{
        public void dosomework();
    }

    public static void main(String[] args) {
        class myrunner2 extends Thread {
            @Override
            public void run() {
                System.out.println(1L);
            }
        }
        class myrunner3 extends Thread {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(2L);

            }
        }

        myrunner2 myrunner2 = new myrunner2();
        myrunner3 myrunner3 = new myrunner3();

        myrunner3.start();
        myrunner2.start();

    }

}