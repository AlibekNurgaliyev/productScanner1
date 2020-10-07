package com.example.alibe.prot1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.widget.ImageButton;

public class prot1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnClickListener {
    ImageButton imgbtncamera, imgbtnrecipe,imgbtn, imgbtndel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prot1);


        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Info");
        builder1.setMessage("This app is done for food recognition with giving you best recipes and food delivery.");
        builder1.setCancelable(true);
        builder1.setNeutralButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgbtn = (ImageButton) findViewById(R.id.imageButton1);

        imgbtncamera = (ImageButton) findViewById(R.id.imageButton);
        imgbtncamera.setOnClickListener(this);

        imgbtnrecipe = (ImageButton) findViewById(R.id.imageButton3);
        imgbtnrecipe.setOnClickListener(this);

        imgbtn = (ImageButton) findViewById(R.id.imageButton1);
        imgbtn.setOnClickListener(this);

        imgbtndel = (ImageButton) findViewById(R.id.imageButton2);
        imgbtndel.setOnClickListener(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        imgbtncamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                setContentView(R.layout.layout3);
//                Intent myIntent = new Intent(imgbtncamera.getContext(), layout3.class);
//                startActivityForResult(myIntent, 0);
//            }
//        });

//        imgbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(R.layout.layout2);
//            }
//        });

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(R.layout.app_bar_prot1);
//            }
//        });


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                Intent intent = new Intent(this, camera.class);
                startActivity(intent);
                break;
            case R.id.imageButton3:
                intent = new Intent(this, recipes.class);
                startActivity(intent);
                break;
            case R.id.imageButton1:
                intent = new Intent(this, viewRecipe.class);
                startActivity(intent);
                break;
            case R.id.imageButton2:
                intent = new Intent(this, delivery.class);
                startActivity(intent);
                break;

            default:
                break;
        }
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
        getMenuInflater().inflate(R.menu.prot1, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(this, camera.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            intent.setType("image/*");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(this, recipes.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(this, delivery.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(this, delivery.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
