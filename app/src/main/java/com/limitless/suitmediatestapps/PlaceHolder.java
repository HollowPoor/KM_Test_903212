package com.limitless.suitmediatestapps;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceHolder {
    @GET("api/users")
    Call<List<UserDataModel>> getpost();
}
