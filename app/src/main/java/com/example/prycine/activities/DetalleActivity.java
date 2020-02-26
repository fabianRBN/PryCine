package com.example.prycine.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.prycine.R;

public class DetalleActivity extends AppCompatActivity {

    TextView nombre, detalle, url ;
    ImageView img;
    RequestOptions options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

    Bundle extras = getIntent().getExtras();

  /*      nombre = findViewById(R.id.tituloPelicula);
        nombre.setText(extras.getString("pe_nombre").toString());*/

        detalle = findViewById(R.id.detallePelicula);
        detalle.setText(extras.getString("pe_descripcion").toString());

        img= findViewById(R.id.imgPelicula);
        options =new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(extras.getString("pe_imag").toString()).apply(options).into(img);





    }
}
