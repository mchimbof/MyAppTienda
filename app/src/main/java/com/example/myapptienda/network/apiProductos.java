package com.example.myapptienda.network;

import com.example.myapptienda.model.modelProductos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiProductos {
    @GET("products")
    Call<List<modelProductos>> getProductos();
}
