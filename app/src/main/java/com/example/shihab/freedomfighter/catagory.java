package com.example.shihab.freedomfighter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
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
import android.widget.ImageView;
import android.widget.Toast;

public class catagory extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView imBirsrasto,imBiruttom,imBirpottik,imBirbikrom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("মুক্তিযোদ্ধা");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imBirsrasto=(ImageView)findViewById(R.id.imBirshato);
        imBirbikrom=(ImageView)findViewById(R.id.imBikrom);
        imBiruttom=(ImageView)findViewById(R.id.imBiruttom);
        imBirpottik=(ImageView)findViewById(R.id.imBirpottik);


        imBirsrasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(catagory.this,AllListActivity.class);
                i.putExtra("searchkey","বীরশ্রেষ্ঠ");
                startActivity(i);

            }
        });


        imBirbikrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(catagory.this,AllListActivity.class);
//                i.putExtra("searchkey","বীরবিক্রম");
//                startActivity(i);

                Toast.makeText(getApplicationContext(),"Up Coming Feature",Toast.LENGTH_SHORT).show();

            }
        });

        imBiruttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(catagory.this,AllListActivity.class);
               i.putExtra("searchkey","বীরউত্তম");
               startActivity(i);
               //Toast.makeText(getApplicationContext(),"Up Coming Feature",Toast.LENGTH_SHORT).show();

            }
        });


        imBirpottik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(catagory.this,AllListActivity.class);
//                i.putExtra("searchkey","বীরপ্রতীক");
//                startActivity(i);
                Toast.makeText(getApplicationContext(),"Up Coming Feature",Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent myIntent = new Intent(this,home.class);
            startActivity(myIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.catagory, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent myIntent = new Intent(this,home.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_gallery) {
            Log.d("Stay", "Stay in same position");
        } else if (id == R.id.nav_search) {

            Intent i = new Intent(catagory.this,AllListActivity.class);
            i.putExtra("searchkey","gotosearch");
            startActivity(i);

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
