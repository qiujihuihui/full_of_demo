package com.full.demo.businessdemo.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.full.demo.R;

import java.util.List;

public class RecyclerDemoAdapter extends RecyclerView.Adapter<RecyclerDemoAdapter.RecyclerViewHolder> {

    private Context context;
    private List<String> titlesList;

    public RecyclerDemoAdapter(Context context, List<String> titlesList) {
        this.context = context;
        this.titlesList = titlesList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder holder = new RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_title, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textView.setText(titlesList.get(position));
    }

    @Override
    public int getItemCount() {
        return titlesList == null ? 0 : titlesList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_demo_title);
        }
    }
}
