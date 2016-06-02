package com.example.andrej.pizzeria;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by Andrej on 16.5.2016..
 */
public class PizzaDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "Proizvodi.db";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_TABLE_PROIZVODI = "Proizvodi";
    private static final String KEY_TABLE_NUTRITIVNE_VRIJEDNOSTI = "Nutritivne_vrijednosti";
    private static PizzaDatabase mInstance;
    private static SQLiteDatabase mDb;

    public PizzaDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public static synchronized PizzaDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PizzaDatabase(context);
        }
        if (mDb == null) {
            mDb = mInstance.getReadableDatabase();
        }
        if (!mDb.isOpen()) {
            mDb = mInstance.getReadableDatabase();
        }
        return mInstance;
    }

    public ArrayList<FoodItemModel> getProizvodi(int category) {
        ArrayList<FoodItemModel> data = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + KEY_TABLE_PROIZVODI + " WHERE KATEGORIJA =" + String.valueOf(category);
        Cursor c = mDb.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                FoodItemModel foodItemModel = new FoodItemModel();
                foodItemModel.setId(c.getInt(FoodItemModel.CURSOR_ID));
                foodItemModel.setCategory(c.getInt(FoodItemModel.CURSOR_KATEGORIJA));
                foodItemModel.setName(c.getString(FoodItemModel.CURSOR_IME));
                foodItemModel.setImage(c.getString(FoodItemModel.CURSOR_SLIKA));
                foodItemModel.setIngredients(c.getString(FoodItemModel.CURSOR_SASTOJCI));
                foodItemModel.setAlergen(c.getString(FoodItemModel.CURSOR_ALERGENI));
                foodItemModel.setFoodPrices(getFoodPrice(foodItemModel.getId()));
                data.add(foodItemModel);
            } while (c.moveToNext());
        }

        c.close();
        mDb.close();
        Log.d("Baza",String.valueOf(data.size()));
        return data;

    }

    private FoodItemModel.FoodPrices getFoodPrice(int category) {
        mDb = getReadableDatabase();
        FoodItemModel.FoodPrices foodItemModel = new FoodItemModel.FoodPrices();
        String selectQuery = "SELECT * FROM " + KEY_TABLE_NUTRITIVNE_VRIJEDNOSTI + " WHERE ID_proizvoda =" + String.valueOf(category);

        Cursor c = mDb.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {

                foodItemModel.setId(c.getInt(FoodItemModel.CURSOR_ID));
                foodItemModel.setId_product(c.getInt(FoodItemModel.FoodPrices.CURSOR_ID_PRODUCT));
                foodItemModel.setTotal(c.getInt(FoodItemModel.FoodPrices.CURSOR_TOTAL));
                foodItemModel.setTotal_fat(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_FAT));
                foodItemModel.setTotal_carbs(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_CARBS));
                foodItemModel.setTotal_protein(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_PROTEIN));
                foodItemModel.setTotal_fiber(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_FIBER));
                foodItemModel.setTotal_sodium(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_SODIUM));
                foodItemModel.setTotal_on_100(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_ON_100));
                foodItemModel.setFat_on_100(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_FAT_ON_100));
                foodItemModel.setCarbs_on_100(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_CARBS_ON_100));
                foodItemModel.setProtein_on_100(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_PROTEIN_ON_100));
                foodItemModel.setFiber_on_100(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_FIBER_ON_100));
                foodItemModel.setSodium_on_100(c.getDouble(FoodItemModel.FoodPrices.CURSOR_TOTAL_SODIUM_ON_100));


            } while (c.moveToNext());
        }
        c.close();
        mDb.close();

        return foodItemModel;

    }
}
