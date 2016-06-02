package com.example.andrej.pizzeria.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import com.example.andrej.pizzeria.Activities.DetailsActivity;
import com.example.andrej.pizzeria.Adapters.FoodItemAdapter;
import com.example.andrej.pizzeria.FoodItemModel;
import com.example.andrej.pizzeria.PizzaDatabase;
import com.example.andrej.pizzeria.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Andrej on 3.5.2016..
 */
public class FoodCategoryFragment extends Fragment {

    public static final int PIZZE = 0;
    public static final int JELA_OD_RIBA_RAKOVA_I_MEKUŠACA = 1;
    public static final int TJESTENINE = 2;
    public static final int SALATE = 3;
    public static final int DESERTI = 4;
    public static final int LEX = 5;
    private static final String CATEGORY = "arg_category";
    private FoodItemAdapter mFoodItemAdapter;
    @Bind(R.id.recycler_view)
    RecyclerView recycler_view;


    public FoodCategoryFragment() {
    }


    private int mCategory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context mContext = getContext();
        mCategory = getArguments().getInt(CATEGORY);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_food_category, container, false);
        ButterKnife.bind(this, inflate);
        recycler_view = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(mGridLayoutManager);
        ArrayList<FoodItemModel> list = PizzaDatabase.getInstance(getContext()).getProizvodi(mCategory);
        mFoodItemAdapter = new FoodItemAdapter(getActivity(), list, R.layout.food_item_adapter);
        recycler_view.setAdapter(mFoodItemAdapter);
        mFoodItemAdapter.setOnItemClickListener(new FoodItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FoodItemModel foodItemModel) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.FOODITEMMODEL, foodItemModel);
                startActivity(intent);

            }
        });

        return inflate;

    }
    // newInstance constructor for creating fragment with arguments

    public static Fragment newInstance(int category) {
        Bundle args = new Bundle();
        args.putInt(CATEGORY, category);
        FoodCategoryFragment fragment = new FoodCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }


}







