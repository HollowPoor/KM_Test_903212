package com.limitless.suitmediatestapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     EditText Polindrome,nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.tfName);
        Polindrome = findViewById(R.id.tfPolindrome);

    }

    public void SecondScreen(View view) {
        Intent a = new Intent(MainActivity.this, SecondScreen.class);
        startActivity(a);
        SharedPreferences.Editor editor = getSharedPreferences("Name", MODE_PRIVATE).edit();
        editor.putString("name", nama.getText().toString());
        editor.apply();
    }


    String checkPolindrome(String A){
        String str = A, reverseStr = "";

        int strLength = str.length();

        for (int i = (strLength - 1); i >=0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }

        if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
            return "isPalindrome";
        }
        else {
            return "notPalindrome";
        }

    }

    public void CheckPolindrome(View view) {

        Polindrome.setText(checkPolindrome(nama.getText().toString()));
    }
}