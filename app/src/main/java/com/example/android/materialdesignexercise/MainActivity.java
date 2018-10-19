package com.example.android.materialdesignexercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        ImageView imageHolder = findViewById(R.id.image_holder);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image_decoration);
        RoundedBitmapDrawable roundDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundDrawable.setCircular(true);
        imageHolder.setImageDrawable(roundDrawable);
    }

}
