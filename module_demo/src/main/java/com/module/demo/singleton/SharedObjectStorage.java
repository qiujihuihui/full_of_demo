package com.module.demo.singleton;

/**
 * 辅助类
 */
public class SharedObjectStorage {
    public IdGenerator2 load(Class clz){
        return new IdGenerator2();
    }

    public void save(IdGenerator2 genetator2, Class clz){

    }
}
