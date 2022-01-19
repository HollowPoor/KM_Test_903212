package com.limitless.suitmediatestapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    TextView NamaUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        NamaUser = findViewById(R.id.tvNameUser);
        SharedPreferences prefs = getSharedPreferences("Name", MODE_PRIVATE);
        NamaUser.setText(prefs.getString("name", ""));

    }

    public void BackFirst(View view) {
        Intent back = new Intent(SecondScreen.this,MainActivity.class);
        startActivity(back);

        this.finish();
    }

    public void ThirdScreen(View view) {
        Intent thaird = new Intent(SecondScreen.this, ThirdScreen.class);
        startActivity(thaird);
    }
}