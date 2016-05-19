package com.example.android.materialdesign.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.materialdesign.Class.Category;
import com.example.android.materialdesign.R;

import java.util.List;

/**
 * Created by flopez on 18-05-2016.
 */
public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.CategoriesViewHolder> {

    private List<Category> categories;

    public AdapterCategories(List<Category> categories){
        this.categories = categories;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        CategoriesViewHolder pvh = new CategoriesViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder categoryHolder, int position) {
        categoryHolder.tv_title.setText(categories.get(position).title);
        categoryHolder.tv_detail.setText(categories.get(position).detail);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_title;
        TextView tv_detail;

        CategoriesViewHolder(View view) {
            super(view);
            cv = (CardView)view.findViewById(R.id.cv_item);
            tv_title = (TextView)view.findViewById(R.id.item_title);
            tv_detail = (TextView)view.findViewById(R.id.item_detail);
        }

    }
}
