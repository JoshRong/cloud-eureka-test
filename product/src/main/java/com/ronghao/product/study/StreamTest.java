package com.ronghao.product.study;

import com.ronghao.common.vo.UserInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @FunctionalInterface
    interface Test {
        public void run();
    }

    @FunctionalInterface
    interface TG {
        public void run();
    }

    public static void main(String[] args) {
//        Stream.of("小王:18", "小杨:20").map(new Function<String, People>() {
//            @Override
//            public People apply(String s) {
//                String[] str = s.split(":");
//                People people = new People(str[0], Integer.valueOf(str[1]));
//                return people;
//            }
//        }).forEach(people -> System.out.println(people));
//
//        List<String> wordList=Arrays.asList("a","b","c");
//
//
//        List<String> output =wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(output);

//
//        List<String> list1 = Arrays.asList("m,k,l,a", "1,3,5,7");
//        List<String> newList = list1.stream().flatMap(s -> {
//            String[] split = s.split(",");
//            Stream<String> s2 = Arrays.stream(split);
//            return s2;
//        }).collect(Collectors.toList());
//        System.out.println(list1);
//        System.out.println(newList);

        Test test = () -> {
            System.out.println("ASd");
        };
        test.run();

        TG tg = () -> {
            System.out.println("asdasdasd");
        };
        tg.run();
        Callable<String> callable =()->{
          return "!23";
        };
    }


}