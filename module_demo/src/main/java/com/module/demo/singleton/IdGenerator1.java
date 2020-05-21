package com.module.demo.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一的单例模式
 */
public class IdGenerator1 {
    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long, IdGenerator1> instances = new ConcurrentHashMap<>();

    private IdGenerator1(){}

    public static IdGenerator1 getInstance(){
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator1());
        return instances.get(currentThreadId);
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
