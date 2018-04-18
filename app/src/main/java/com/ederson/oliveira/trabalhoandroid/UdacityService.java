package com.ederson.oliveira.trabalhoandroid;

import android.text.StaticLayout;

import com.ederson.oliveira.trabalhoandroid.models.UdacityCatalog;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aluno on 16/04/18.
 */

public interface UdacityService {

    public static final String BASE_URL = "https://www.udacity.com/public-api/v0/";

    @GET("courses")
    Call<UdacityCatalog> listCatalog();


}
