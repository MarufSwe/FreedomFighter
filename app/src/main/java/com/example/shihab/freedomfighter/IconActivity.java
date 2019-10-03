package com.example.shihab.freedomfighter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.media.MediaPlayer;

public class IconActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    MediaPlayer sound;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);


        sound = MediaPlayer.create(this, R.raw.bd);
        SharedPreferences getPrefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        boolean music = getPrefs.getBoolean("checkbox", true);

        if (music == true)
            sound.start();

        tv=(TextView)findViewById(R.id.text);
        iv=(ImageView)findViewById(R.id.imageView2);
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.opening_animation);
        tv.setAnimation(animation);
        iv.setAnimation(animation);



        Thread timer=new Thread() {

            Intent myIntent = new Intent(IconActivity.this,home.class);
            public void run() {


                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(myIntent);
                    finish();
                }


            }};

        timer.start();
    }


}
