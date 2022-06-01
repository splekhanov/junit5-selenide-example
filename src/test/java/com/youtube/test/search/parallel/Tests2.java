package com.youtube.test.search.parallel;

import org.junit.jupiter.api.*;

public class Tests2 {

    @BeforeAll
    public static void start() {
        System.out.println("=======Starting junit 5 tests @BeforeAll========");
    }

    @BeforeEach
    public void setup() {
        System.out.println("=======Setting up the prerequisites @BeforeEach========");

    }
    @Test
    void test1_FirstTest() {
        System.out.println(Thread.currentThread().getStackTrace()[1]
                .getMethodName()+" => executed successfully");
    }

    @Test
    void test1_SecondTest() {
        System.out.println(Thread.currentThread().getStackTrace()[1]
                .getMethodName()+" => executed successfully");
    }

    @Test
    void test1_ThirdTest() {
        System.out.println(Thread.currentThread().getStackTrace()[1]
                .getMethodName()+" => executed successfully");
    }
    @Test
    void test1_FourthTest() {
        System.out.println(Thread.currentThread().getStackTrace()[1]
                .getMethodName()+" => executed successfully");
    }


    @AfterEach
    public void tearDown() {
        System.out.println("Tests ended @AfterEach");
    }

    @AfterAll
    public static void end() {
        System.out.println("All the tests are executed @AfterAll");

    }
}
