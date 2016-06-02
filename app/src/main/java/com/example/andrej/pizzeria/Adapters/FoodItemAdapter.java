package com.example.andrej.pizzeria.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andrej.pizzeria.FoodItemModel;
import com.example.andrej.pizzeria.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Andrej on 4.5.2016..
 */
public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.Holder> {
    private ArrayList<FoodItemModel> items;
    private int food_item_adapter;
    private Context mContext;
    private OnItemClickListener mListener;


    public FoodItemAdapter(Context context, ArrayList<FoodItemModel> items, int food_item_adapter) {
        this.mContext = context;
        this.items =items;
        this.food_item_adapter = food_item_adapter;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(food_item_adapter, parent, false);
        return new Holder(v);
    }
    @Override
    public void onBindViewHolder(final FoodItemAdapter.Holder holder, final int position) {
        final FoodItemModel item = items.get(position);
        holder.tv_title.setText(item.getName());
        holder.tv_subtitle.setText(item.getIngredients());
        Glide.with(mContext)
                .load(item.getImage())
                .centerCrop()
                .into(holder.civ_image);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onItemClick(item);
                }

            }
        });
    }



    @Override
    public int getItemCount() {
        return items.size();}

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(FoodItemModel foodItemModel);
    }




    public class Holder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title)
        TextView tv_title;
        @Bind(R.id.civ_image)
        CircularImageView civ_image;
        @Bind(R.id.tv_subtitle)
        TextView tv_subtitle;
        @Bind(R.id.item_root)
        RelativeLayout root;


        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}




