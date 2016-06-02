package com.example.andrej.pizzeria.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andrej.pizzeria.FoodItemModel;
import com.example.andrej.pizzeria.Order;
import com.example.andrej.pizzeria.R;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.andrej.pizzeria.FoodItemModel.*;

public class DetailsActivity extends AppCompatActivity {
    public static final String FOODITEMMODEL = "FoodItemModel";


    @Bind(R.id.iv_pizza)
    ImageView imageView;
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.tv_subtitle)
    TextView tv_subtitle;
    @Bind(R.id.tv_alergen)
    TextView tv_alergen;
    //@Bind(R.id.tv_total)
    //TextView tv_total;
    @Bind(R.id.tv_total_value)
    TextView tv_total_value;
    @Bind(R.id.tv_fat_total_value)
    TextView tv_fat_total_value;
    @Bind(R.id.tv_carbs_total_value)
    TextView tv_carbs_total_value;
    @Bind(R.id.tv_protein_total_value)
    TextView tv_protein_total_value;
    @Bind(R.id.tv_fiber_total_value)
    TextView tv_fiber_total_value;
    @Bind(R.id.tv_sodium_total_value)
    TextView tv_sodium_total_value;
    @Bind(R.id.tv_total_on_100_value)
    TextView tv_total_on_100_value;
    @Bind(R.id.tv_fat_total_on_100_value)
    TextView tv_fat_total_on_100_value;
    @Bind(R.id.tv_carbs_total_on_100_value)
    TextView tv_carbs_total_on_100_value;
    @Bind(R.id.tv_protein_total_on_100_value)
    TextView tv_protein_total_on_100_value;
    @Bind(R.id.tv_fiber_total_on_100_value)
    TextView tv_fiber_total_on_100_value;
    @Bind(R.id.tv_sodium_total_on_100_value)
    TextView tv_sodium_total_on_100_value;
    @Bind(R.id.bt_add_order)
    Button bt_add_order;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        final FoodItemModel foodItemModel = getIntent().getExtras().getParcelable(FOODITEMMODEL);
        Glide.with(this).load(foodItemModel.getImage()).centerCrop().into(imageView);
        tv_title.setText(foodItemModel.getName());
        tv_subtitle.setText(Html.fromHtml(foodItemModel.getIngredients()));
        tv_alergen.setText(foodItemModel.getAlergen());
        //tv_total.setText(String.valueOf(foodItemModel.getFoodPrices().getTotal())+"g");
        tv_total_value.setText(String.valueOf(foodItemModel.getFoodPrices().getTotal()));
        tv_fat_total_value.setText(String.valueOf(foodItemModel.getFoodPrices().getTotal_fat())+"g");
        tv_carbs_total_value.setText(String.valueOf(foodItemModel.getFoodPrices().getTotal_carbs())+"g");
        tv_protein_total_value.setText(String.valueOf(foodItemModel.getFoodPrices().getTotal_protein()+"g"));
        tv_fiber_total_value.setText(String.valueOf(foodItemModel.getFoodPrices().getTotal_fiber())+"g");
        tv_sodium_total_value.setText(String.valueOf(foodItemModel.getFoodPrices().getTotal_sodium())+"g");
        tv_total_on_100_value.setText("\n"+String.valueOf(foodItemModel.getFoodPrices().getTotal_on_100()));
        tv_fat_total_on_100_value.setText(String.valueOf(foodItemModel.getFoodPrices().getFat_on_100())+"g");
        tv_carbs_total_on_100_value.setText(String.valueOf(foodItemModel.getFoodPrices().getCarbs_on_100())+"g");
        tv_protein_total_on_100_value.setText(String.valueOf(foodItemModel.getFoodPrices().getProtein_on_100())+"g");
        tv_fiber_total_on_100_value.setText(String.valueOf(foodItemModel.getFoodPrices().getFiber_on_100())+"g");
        tv_sodium_total_on_100_value.setText(String.valueOf(foodItemModel.getFoodPrices().getSodium_on_100())+"g");
        bt_add_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order.getInstance().addToCard(foodItemModel);
                finish();



            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

