package com.full.demo.businessdemo.recycleview;

import android.view.View;

public interface OnItemsClickListener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);
}
