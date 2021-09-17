package com.barmej.suggest_activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private Random r;
    private int currentIndex;
    public int[] Activities;
    public String[] Activities_Names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        Activities = getResources().getIntArray(R.array.Activities);
        Activities_Names = getResources().getStringArray(R.array.Activities_Names);
        r = new Random();
        imageView.setImageResource(Activities[currentIndex]);
        textView.setText(Activities_Names[currentIndex]);


    }


    public void next(View view) {
        if (currentIndex < Activities.length - 1) {

            currentIndex++;
            textView.setText(Activities_Names[currentIndex]);
            imageView.setImageResource(Activities[currentIndex]);
        } else {
            Toast.makeText(this, "Please Use the Back button", Toast.LENGTH_SHORT).show();
        }

    }

    public void back(View view) {
        if (currentIndex > 0) {
            currentIndex--;
            textView.setText(Activities_Names[currentIndex]);
            imageView.setImageResource(Activities[currentIndex]);

        } else {
            Toast.makeText(this, "Please Use the Previous button", Toast.LENGTH_SHORT).show();
        }

    }

    public void randomeactivites(View view) {

        if (currentIndex < Activities.length) {
            textView.setText(Activities_Names[currentIndex]);
            imageView.setImageResource(Activities[currentIndex]);
            currentIndex = r.nextInt(10);
        } else {
            currentIndex = 0;
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentIndex", currentIndex);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentIndex = savedInstanceState.getInt("currentIndex");
        imageView.setImageResource(Activities[currentIndex]);
        textView.setText(Activities_Names[currentIndex]);

    }
}

