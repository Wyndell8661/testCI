package com.example.demo;

import org.junit.Test;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RSATest {

    @Test
    public void test1(){
        Byte a = -15;
        Byte b =  122;
        //将负数变成正数；
        int c = a&0xFF;
        int d = b&0xFF;
        System.out.println(Integer.toHexString(c));
        System.out.println(d);
    }

    @Test
    public void test2(){
        List<String> list1 = Arrays.asList("Hi","Hello","你好");
        List<String> list2 = Arrays.asList("张三","李四","王五");

        list1.stream().flatMap(item1->list2.stream().map(item2->item1+" "+item2)).
                peek(e-> System.out.println(e)).collect(Collectors.toList());
    }


    @Test
    public void test3(){
        List<String> list1 = Arrays.asList("Hi","Hello","你好","你好","金城武");
        list1.stream().limit(3).peek(e-> System.out.println(e)).collect(Collectors.toList());
        list1.stream().skip(2).peek(e-> System.out.println(e)).collect(Collectors.toList());
        list1.stream().mapToInt(e->e.length()).forEach(e-> System.out.println(e));
    }

    @Test
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 2);
        Date day = calendar.getTime();
        System.out.println(day);
    }


    @Test
    public void test4(){
        List<String> list1 = Arrays.asList("Hi","Hello","你好","你好呀");
        List<String> list2 = Arrays.asList("张三","李四","王五");
        Map<String, List<String>> collect = list1.stream().flatMap(item1 -> list2.stream().map(item2 -> item1 + "：" + item2))
                .peek(e -> System.out.println(e)).collect(Collectors.groupingBy(e -> e.substring(0, 1)));
        boolean b = list2.stream().anyMatch(e -> "姜鹏".equals(e));
        System.out.println(b);
    }


    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());
        Future<String> future = executor.submit(() -> {
            Thread.sleep(8000);
            return "hello world";
        });
        System.out.println(future.get());
        System.out.println("done");
    }


    @Test
    public void test5(){
        List<String> first= Arrays.asList("two", "one", "three", "four");
        List<String> second= Arrays.asList("A", "B", "C", "D");
        //Stream.of将两个集合合并成一个流，注意这个流的类型是Stream<List<String>>
        Stream.of(first,second).flatMap(Collection::stream).forEach(System.out::println);
        Stream.of(first).sequential().forEach(System.out::println);
    }

}
