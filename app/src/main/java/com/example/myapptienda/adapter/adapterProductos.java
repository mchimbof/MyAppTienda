package com.example.myapptienda.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapptienda.MainActivityDetalles;
import com.example.myapptienda.R;
import com.example.myapptienda.model.modelProductos;

import java.util.List;

public class adapterProductos extends RecyclerView.Adapter<adapterProductos.ViewHolder> {
    private List<modelProductos> productos;
    private Context context;

    public adapterProductos(List<modelProductos> productos, Context context) {
        this.productos = productos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_tienda,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv_Title.setText(productos.get(position).getTitle());
        holder.iv_Category.setText(productos.get(position).getCategory());
        holder.iv_Description.setText(productos.get(position).getDescription());
        holder.iv_Price.setText(String.valueOf(productos.get(position).getPrice()));
        Glide.with(context).load(productos.get(position).getImage()).into(holder.iv_Image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleProduct = productos.get(position).getTitle();
                String categoryProduct = productos.get(position).getCategory();
                String descryptionProduct = productos.get(position).getDescription();
                String priceProduct = String.valueOf(productos.get(position).getPrice());
                String imageProduct = productos.get(position).getImage();

                Intent intent = new Intent(context, MainActivityDetalles.class);
                intent.putExtra("Title", titleProduct);
                intent.putExtra("Category", categoryProduct);
                intent.putExtra("Description", descryptionProduct);
                intent.putExtra("Price", priceProduct);
                intent.putExtra("Image", imageProduct);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_Image;
        private TextView iv_Title;
        private TextView iv_Category;
        private TextView iv_Description;
        private TextView iv_Price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_Image = itemView.findViewById(R.id.jsonImagen);
            iv_Title = itemView.findViewById(R.id.jsonTitle);
            iv_Category = itemView.findViewById(R.id.jsonCategory);
            iv_Description = itemView.findViewById(R.id.jsonDescryption);
            iv_Price = itemView.findViewById(R.id.jsonPrice);
        }
    }
}
