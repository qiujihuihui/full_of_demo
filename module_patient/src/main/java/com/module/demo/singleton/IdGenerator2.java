package com.module.demo.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 集群唯一的单例模式
 * 注意：加锁处理的部分
 */
public class IdGenerator2 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator2 instance;
    private static SharedObjectStorage sStorage = new SharedObjectStorage();
//    private static DistributedLock lock = new DistributedLock();

    public IdGenerator2() {}

    public synchronized static IdGenerator2 getInstance(){
        if (instance == null) {
//            lock.lock();
            instance = sStorage.load(IdGenerator2.class);
        }    return instance;
    }

    public synchronized void freeInstance() {
        sStorage.save(this, IdGenerator2.class);
        instance = null;
        //释放对象
//        lock.unlock();
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
