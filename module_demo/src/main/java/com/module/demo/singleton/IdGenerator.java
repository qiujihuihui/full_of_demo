package com.module.demo.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 经典饿汉式单例模式
 * 说明：一个进程内对象唯一
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator(){

    }

    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
