package com.module.demo.singleton;

public class TestSingletonPattern {
    long id = IdGenerator.getInstance().getId();

    long id1 = IdGenerator1.getInstance().getId();


}
