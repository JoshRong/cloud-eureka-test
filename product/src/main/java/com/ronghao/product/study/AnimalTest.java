package com.ronghao.product.study;

public class AnimalTest {
    private final String ANIMAL = "动物";

    public void accessTest() {
        System.out.println("匿名内部类访问其外部类方法");
    }

    class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public void printAnimalName() {
            System.out.println(bird.name);
        }
    }

    // 鸟类，匿名子类，继承自Animal类，可以覆写父类方法
    Animal bird = new Animal("布谷鸟") {

        @Override
        public void printAnimalName() {
            // 访问外部类成员
            accessTest();
            // 访问外部类final修饰的变量
            System.out.println(ANIMAL);
            super.printAnimalName();
        }
    };

    public void print() {
        bird.printAnimalName();
    }

    public static void main(String[] args) {

        AnimalTest animalTest = new AnimalTest();
        animalTest.print();
    }
}