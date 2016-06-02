package com.example.andrej.pizzeria.Activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ProgressDialog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.andrej.pizzeria.FoodItemModel;
import com.example.andrej.pizzeria.Fragment.FoodCategoryFragment;
import com.example.andrej.pizzeria.Order;
import com.example.andrej.pizzeria.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final int PIZZE = 0;
    private Context mContext = this;//
    public String mTitle;
    public Toolbar mToolbar;
    private ProgressBar spinner;
    private ProgressDialog mProgressDialog;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mToolbar.setTitle("Pizze");
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodItemModel> allProducts = Order.getInstance().getAllProducts();
                if (allProducts.isEmpty()) {
                    Snackbar.make(view, "Košarica je prazna", Snackbar.LENGTH_LONG).show();
                } else {
                    sendMail(allProducts);
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_pizze);

        FragmentManager fm = getSupportFragmentManager();//  Menager to fragments
        FragmentTransaction ft = fm.beginTransaction();// Starting fragments
        ft.replace(R.id.container, FoodCategoryFragment.newInstance(FoodCategoryFragment.PIZZE));
        ft.commitAllowingStateLoss();

    }

    private void sendMail(final ArrayList<FoodItemModel> allProducts) {
        AsyncHttpClient client = new AsyncHttpClient();
        final RequestParams param = new RequestParams();
        param.put("order", new Gson().toJson(allProducts));
        Log.d("order", new Gson().toJson(allProducts));
        client.post("http://studioadriatic.com/andrej/order.php", param, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                 mProgressDialog = new ProgressDialog(MainActivity.this);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgressDialog.setTitle("Naruđžba se šalje");
                mProgressDialog.setMessage("Molim pričekajte");
                mProgressDialog.show();


            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                Toast.makeText(getApplicationContext(), "NARUĐŽBA JE ZAPRIMLJENA",
                        Toast.LENGTH_LONG).show();
                Order.getInstance().clearOrder();
                mProgressDialog.cancel();
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                mProgressDialog.dismiss();


            }


        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int Primary = ContextCompat.getColor(mContext, R.color.pizze);
        int PrimaryDark = ContextCompat.getColor(mContext, R.color.pizze_dark);
        FragmentManager fm = getSupportFragmentManager();//  Menager to fragments
        FragmentTransaction ft = fm.beginTransaction();// Starting fragments


        switch (item.getItemId()) {
            case R.id.nav_pizze:
                mTitle = getString(R.string.pizze); //Red
                ft.replace(R.id.container, FoodCategoryFragment.newInstance(FoodCategoryFragment.PIZZE));

                break;
            case R.id.nav_riba_rakova_mekusaca:
                mTitle = getString(R.string.jela_od_riba_rakova_mekusaca);
                ft.replace(R.id.container, FoodCategoryFragment.newInstance(FoodCategoryFragment.JELA_OD_RIBA_RAKOVA_I_MEKUŠACA));
                break;
            case R.id.nav_tjestenine:
                mTitle = getString(R.string.tjestenine); //Purple
                ft.replace(R.id.container, FoodCategoryFragment.newInstance(FoodCategoryFragment.TJESTENINE));
                break;
            case R.id.nav_salate:
                mTitle = getString(R.string.salate); //green
                ft.replace(R.id.container, FoodCategoryFragment.newInstance(FoodCategoryFragment.SALATE));
                break;
            case R.id.nav_deserti:
                mTitle = getString(R.string.deserti); //Purple
                ft.replace(R.id.container, FoodCategoryFragment.newInstance(FoodCategoryFragment.DESERTI));
                break;
            case R.id.nav_lex:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://eur-lex.europa.eu/legal-content/HR/TXT/PDF/?uri=CELEX:32011R1169&from=HR"));
                startActivity(browserIntent);


        }
        ft.commitAllowingStateLoss();
        if (mToolbar == null) {
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        mToolbar = supportActionBar;
    }

}
