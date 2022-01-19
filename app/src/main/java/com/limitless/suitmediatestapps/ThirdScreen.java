package com.limitless.suitmediatestapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ThirdScreen extends AppCompatActivity {

    RecyclerView rcyUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);

        rcyUser = findViewById(R.id.rcyUser);
        rcyUser.setHasFixedSize(true);
        rcyUser.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceHolder placeHolder = retrofit.create(PlaceHolder.class);
        Call<List<UserDataModel>> call = placeHolder.getpost();
        call.enqueue(new Callback<List<UserDataModel>>() {
            @Override
            public void onResponse(Call<List<UserDataModel>> call, Response<List<UserDataModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(ThirdScreen.this,response.code(),Toast.LENGTH_LONG).show();
                    return;
                }
                List<UserDataModel> UserList = response.body();
                UserAdapter userAdapter = new UserAdapter(ThirdScreen.this, UserList);
                rcyUser.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<UserDataModel>> call, Throwable t) {
                Toast.makeText(ThirdScreen.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}