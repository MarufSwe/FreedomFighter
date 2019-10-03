package com.example.shihab.freedomfighter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;

import java.io.IOException;

import static android.app.PendingIntent.getActivity;

public class AllListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    String searchKey;
    Fragment currentFragment ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        searchKey = getIntent().getExtras().getString("searchkey");
        //setTitle(searchKey);
        ///Log.d("Fast Activity", searchKey);






 // Navigation  Code

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


  //fragment call

        if(searchKey.equalsIgnoreCase("gotosearch") || searchKey.equalsIgnoreCase(String.valueOf(R.string.app_name))){
            setTitle(R.string.app_name);
            AllListSearchShowAFragment objFragment = new AllListSearchShowAFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame, objFragment).commit();
        } else {
            setTitle(searchKey);
            AllListShowFragment objFragment = new AllListShowFragment();

            Bundle args = new Bundle();
            args.putString("searchKey",searchKey);
            objFragment.setArguments(args);


            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame, objFragment).commit();
        }





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        //currentFragment = this.getFragmentManager().findFragmentById(R.id.frame);
        currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
        Log.d("Current Fragment Name",String.valueOf(currentFragment));


/// 8888888888888888888888888***************************************8888888888888888888888

        android.app.FragmentManager fm3 = getFragmentManager();
        Log.i("Back Stracck Entry ", String.valueOf(fm3.getBackStackEntryCount()));

        String checkTitle = (String) this.getTitle();
        if (fm3.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
        } else if (currentFragment instanceof detailsInfoFragment ){

            Log.i("MainActivity", this.searchKey+"  ==   "+checkTitle);
                if(checkTitle.equalsIgnoreCase("মুক্তিযোদ্ধা")){
                    AllListSearchShowAFragment objFragment = new AllListSearchShowAFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame, objFragment).commit();
                } else {
                    Log.i("MainActivity", "nothing on backstack, calling super");
                    AllListShowFragment objFragment = new AllListShowFragment();
                    Bundle args = new Bundle();
                    args.putString("searchKey", searchKey);
                    objFragment.setArguments(args);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame, objFragment).commit();
                }


        }  else if( currentFragment instanceof AllListSearchShowAFragment  ){
                    if (this.searchKey.equalsIgnoreCase("gotosearch")){
                        Intent myIntent = new Intent(AllListActivity.this,catagory.class);
                        startActivity(myIntent);
                    } else {
                        Intent i = new Intent(AllListActivity.this,AllListActivity.class);
                        i.putExtra("searchkey",this.searchKey);
                        startActivity(i);
                    }
        } else {
            Intent myIntent = new Intent(this,catagory.class);
            startActivity(myIntent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.all_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {

            setTitle(R.string.app_name);
            AllListSearchShowAFragment objFragment = new AllListSearchShowAFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame, objFragment).commit();

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
            Intent myIntent = new Intent(this,home.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_gallery) {
            Intent myIntent = new Intent(this,catagory.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_search) {
            setTitle(R.string.app_name);
            AllListSearchShowAFragment objFragment = new AllListSearchShowAFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame, objFragment).commit();
        } else if (id == R.id.nav_manage) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


