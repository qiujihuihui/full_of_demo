package com.module.demo.adapter;

/**
 * Created by shenh
 * On 2020/7/31
 * Description: 类适配器
 */
public class MyAdapter extends OriginAdapter implements ITarget
{

    @Override
    public void get() {
        super.getOrigin();
    }

    @Override
    public void put() {
        name = "Johan";
        // 重新实现父类的putOrigin()
    }

    // 这里refresh()不需要实现，直接继承自OriginAdapter，这是跟对象适配器最大的不同点
}
