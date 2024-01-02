package com.example.myapptienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivityDetalles extends AppCompatActivity {
private TextView titulo, categoria, precio;
private ImageView imagen;
private Button atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalles);

        titulo = findViewById(R.id.jsonTitleProducto);
        categoria = findViewById(R.id.jsonCategoryProducto);
        precio = findViewById(R.id.jsonPriceProducto);
        imagen = findViewById(R.id.jsonImagenProducto) ;

        atras = findViewById(R.id.btnCancel);

        String title = getIntent().getStringExtra("Title");
        String category = getIntent().getStringExtra("Category");
        String description = getIntent().getStringExtra("Description");
        String price = getIntent().getStringExtra("Price");
        String image = getIntent().getStringExtra("Image");

        Log.d("","Datos: "+title +"\n"+category+"\n"+description+"\n"+price+"\n"+image+"\n");

        titulo.setText(title);
        categoria.setText(category);
        precio.setText(price);
        Picasso.get().load(image).into(imagen);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}