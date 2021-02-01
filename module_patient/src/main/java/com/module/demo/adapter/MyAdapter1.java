package com.module.demo.adapter;

/**
 * Created by shenh
 * On 2020/7/31
 * Description: 对象适配器
 */
public class MyAdapter1 implements ITarget
{
    private OriginAdapter adapter;

    public MyAdapter1(OriginAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void get() {
        adapter.getOrigin();
    }

    @Override
    public void put() {
        adapter.name = "Tommy";
    }

    @Override
    public void refresh() {
        adapter.refresh();
    }
}
