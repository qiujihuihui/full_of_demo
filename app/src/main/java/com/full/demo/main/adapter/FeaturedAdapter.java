package com.full.demo.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.full.demo.R;
import com.full.demo.main.model.FeaturedBean;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 我的页面的适配器
 */
public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    private Context context;
    private List<FeaturedBean> featuredBeans;

    public FeaturedAdapter(Context context, List<FeaturedBean> featuredBeans) {
        this.context = context;
        this.featuredBeans = featuredBeans;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeaturedViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_featured, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        holder.tvRight.setText(featuredBeans.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return featuredBeans == null ? 0 : featuredBeans.size();
    }

    class FeaturedViewHolder extends RecyclerView.ViewHolder {

        @ViewInject(R.id.img_featured_item)
        ImageView imgLeft;
        @ViewInject(R.id.tv_featured_item)
        TextView tvRight;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            x.view().inject(itemView);
        }
    }
}
