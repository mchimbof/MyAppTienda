package com.example.myapptienda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapptienda.adapter.adapterProductos;
import com.example.myapptienda.model.modelProductos;
import com.example.myapptienda.network.apiClient;
import com.example.myapptienda.network.apiProductos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private  List<modelProductos> productos;
    private  RecyclerView recyclerView;
    private adapterProductos adapterproductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.jsonProductos);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        productosTienda();

    }
    public void productosTienda(){

        Call<List<modelProductos>> call = apiClient.getClient().create(apiProductos.class).getProductos();

        call.enqueue(new Callback<List<modelProductos>>() {
            @Override
            public void onResponse(Call<List<modelProductos>> call, Response<List<modelProductos>> response) {
                if(response.isSuccessful()){
                    productos = response.body();
                    adapterproductos = new adapterProductos(productos,getApplicationContext());
                    recyclerView.setAdapter(adapterproductos);
                }
            }

            @Override
            public void onFailure(Call<List<modelProductos>> call, Throwable t) {
                Log.d("","Error...");
            }
        });

    }

}


