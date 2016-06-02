package com.example.andrej.pizzeria;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Andrej on 3.5.2016..
 */
public class FoodItemModel implements Parcelable {
    //Cursor ID
    public static final int CURSOR_ID = 0;
    public static final int CURSOR_KATEGORIJA = 1;
    public static final int CURSOR_IME = 2;
    public static final int CURSOR_SLIKA = 3;
    public static final int CURSOR_SASTOJCI = 4;
    public static final int CURSOR_ALERGENI = 5;

    //DB Keys
    public static final String KEY_ID = "ID";
    public static final String KEY_KATEGORIJA = "KATEGORIJA";
    public static final String KEY_IME = "IME";
    public static final String KEY_SLIKA = "SLIKA";
    public static final String KEY_SASTOJCI = "SASTOJCI";
    public static final String KEY_ALERGENI = "ALERGENI";
    public static final String KEY_LAST_UPDATE = "last_update";

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    private int category;
    private int id;
    private String image;
    private String ingredients;
    private String title;
    private String subtitle;
    private String name;
    private String alergen;


    public String getAlergen() {
        return alergen;
    }

    public void setAlergen(String alergen) {
        this.alergen = alergen;
    }

    public FoodPrices getFoodPrices() {
        return foodPrices;
    }

    public void setFoodPrices(FoodPrices foodPrices) {
        this.foodPrices = foodPrices;
    }

    private FoodPrices foodPrices;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public FoodItemModel() {
    }


    public static class FoodPrices implements Parcelable {
        //Cursor ID
        public static final int CURSOR_ID = 0;
        public static final int CURSOR_ID_PRODUCT = 1;
        public static final int CURSOR_TOTAL = 2;
        public static final int CURSOR_TOTAL_FAT = 3;
        public static final int CURSOR_TOTAL_CARBS = 4;
        public static final int CURSOR_TOTAL_PROTEIN = 5;
        public static final int CURSOR_TOTAL_FIBER = 6;
        public static final int CURSOR_TOTAL_SODIUM = 7;
        public static final int CURSOR_TOTAL_ON_100 = 8;
        public static final int CURSOR_TOTAL_FAT_ON_100 = 9;
        public static final int CURSOR_TOTAL_CARBS_ON_100 = 10;
        public static final int CURSOR_TOTAL_PROTEIN_ON_100 = 11;
        public static final int CURSOR_TOTAL_FIBER_ON_100 = 12;
        public static final int CURSOR_TOTAL_SODIUM_ON_100 = 13;


        //DB Keys
        public static final String KEY_ID = "ID";
        public static final String KEY_ID_PRODUCT = "ID_PROIZVODA";
        public static final String KEY_TOTAL = "UKUPNO";
        public static final String KEY_TOTAL_FAT = "MASTI_UKUPNO";
        public static final String KEY_TOTAL_CARBS = "UGLJIKOHIDRATI_UKUPNO";
        public static final String KEY_TOTAL_PROTEIN = "PROTEINA_UKUPNO";
        public static final String KEY_TOTAL_FIBER = "VLAKANA_UKUPNO";
        public static final String KEY_TOTAL_SODIUM = "NATRIJA_UKUPNO";
        public static final String KEY_TOTAL_ON_100 = "UKUPNO_NA_100";
        public static final String KEY_FAT_ON_100 = "MASTI_NA_100";
        public static final String KEY_CARBS_ON_100 = "UGLJIKOHIDRATI_NA_100";
        public static final String KEY_PROTEIN_ON_100 = "PROTEINI_NA_100";
        public static final String KEY_FIBER_ON_100 = "VLAKNA_NA_100";
        public static final String KEY_SODIUM_ON_100 = "NATRIJ_NA_100";


        private int id;
        private int id_product;
        private int total;
        private double total_fat;
        private double total_carbs;
        private double total_protein;
        private double total_fiber;
        private double total_sodium;
        private double total_on_100;
        private double fat_on_100;
        private double carbs_on_100;
        private double protein_on_100;
        private double fiber_on_100;
        private double sodium_on_100;

        public double getSodium_on_100() {
            return sodium_on_100;
        }

        public void setSodium_on_100(double sodium_on_100) {
            this.sodium_on_100 = sodium_on_100;
        }

        public double getTotal_fat() {
            return total_fat;
        }

        public void setTotal_fat(double total_fat) {
            this.total_fat = total_fat;
        }







        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }




        public double getTotal_on_100() {
            return total_on_100;
        }

        public void setTotal_on_100(double total_on_100) {
            this.total_on_100 = total_on_100;
        }







        public double getTotal_carbs() {
            return total_carbs;
        }

        public void setTotal_carbs(double total_carbs) {
            this.total_carbs = total_carbs;
        }

        public double getTotal_protein() {
            return total_protein;
        }

        public void setTotal_protein(double total_protein) {
            this.total_protein = total_protein;
        }

        public double getTotal_fiber() {
            return total_fiber;
        }

        public void setTotal_fiber(double total_fiber) {
            this.total_fiber = total_fiber;
        }

        public double getTotal_sodium() {
            return total_sodium;
        }

        public void setTotal_sodium(double total_sodium) {
            this.total_sodium = total_sodium;
        }



        public double getFat_on_100() {
            return fat_on_100;
        }

        public void setFat_on_100(double fat_on_100) {
            this.fat_on_100 = fat_on_100;
        }

        public double getCarbs_on_100() {
            return carbs_on_100;
        }

        public void setCarbs_on_100(double carbs_on_100) {
            this.carbs_on_100 = carbs_on_100;
        }

        public double getProtein_on_100() {
            return protein_on_100;
        }

        public void setProtein_on_100(double protein_on_100) {
            this.protein_on_100 = protein_on_100;
        }

        public double getFiber_on_100() {
            return fiber_on_100;
        }

        public void setFiber_on_100(double fiber_on_100) {
            this.fiber_on_100 = fiber_on_100;
        }



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getId_product() {
            return id_product;
        }

        public void setId_product(int id_product) {
            this.id_product = id_product;
        }


        public FoodPrices() {
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeInt(this.id_product);
            dest.writeInt(this.total);
            dest.writeDouble(this.total_fat);
            dest.writeDouble(this.total_carbs);
            dest.writeDouble(this.total_protein);
            dest.writeDouble(this.total_fiber);
            dest.writeDouble(this.total_sodium);
            dest.writeDouble(this.total_on_100);
            dest.writeDouble(this.fat_on_100);
            dest.writeDouble(this.carbs_on_100);
            dest.writeDouble(this.protein_on_100);
            dest.writeDouble(this.fiber_on_100);
            dest.writeDouble(this.sodium_on_100);
        }

        protected FoodPrices(Parcel in) {
            this.id = in.readInt();
            this.id_product = in.readInt();
            this.total = in.readInt();
            this.total_fat = in.readDouble();
            this.total_carbs = in.readDouble();
            this.total_protein = in.readDouble();
            this.total_fiber = in.readDouble();
            this.total_sodium = in.readDouble();
            this.total_on_100 = in.readDouble();
            this.fat_on_100 = in.readDouble();
            this.carbs_on_100 = in.readDouble();
            this.protein_on_100 = in.readDouble();
            this.fiber_on_100 = in.readDouble();
            this.sodium_on_100 = in.readDouble();
        }

        public static final Creator<FoodPrices> CREATOR = new Creator<FoodPrices>() {
            @Override
            public FoodPrices createFromParcel(Parcel source) {
                return new FoodPrices(source);
            }

            @Override
            public FoodPrices[] newArray(int size) {
                return new FoodPrices[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.category);
        dest.writeInt(this.id);
        dest.writeString(this.image);
        dest.writeString(this.ingredients);
        dest.writeString(this.title);
        dest.writeString(this.subtitle);
        dest.writeString(this.name);
        dest.writeString(this.alergen);
        dest.writeParcelable(this.foodPrices, flags);
    }

    protected FoodItemModel(Parcel in) {
        this.category = in.readInt();
        this.id = in.readInt();
        this.image = in.readString();
        this.ingredients = in.readString();
        this.title = in.readString();
        this.subtitle = in.readString();
        this.name = in.readString();
        this.alergen = in.readString();
        this.foodPrices = in.readParcelable(FoodPrices.class.getClassLoader());
    }

    public static final Creator<FoodItemModel> CREATOR = new Creator<FoodItemModel>() {
        @Override
        public FoodItemModel createFromParcel(Parcel source) {
            return new FoodItemModel(source);
        }

        @Override
        public FoodItemModel[] newArray(int size) {
            return new FoodItemModel[size];
        }
    };
}
