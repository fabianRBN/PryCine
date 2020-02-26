package com.example.prycine.activities;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.example.prycine.MenuActivity;
import com.example.prycine.adapters.HorarioAdapter;
import com.example.prycine.adapters.RecyclerViewAdapter;
import com.example.prycine.models.Calendario;
import com.example.prycine.models.Pelicula;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prycine.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ScrollingDetalleActivity extends AppCompatActivity {


    TextView nombre, detalle, url ;
    String id_pelicula;
    ImageView img;
    RequestOptions options;
    private final String JSON_URL="http://192.168.100.6:3000/peliculas/calendario/";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Calendario> listCalendario;
    private RecyclerView recyclerView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        listCalendario = new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        /*nombre = findViewById(R.id.tituloPelicula);
        nombre.setText(extras.getString("pe_nombre").toString());*/
        toolbar.setTitle(extras.getString("pe_nombre").toString());
        setSupportActionBar(toolbar);
        detalle = findViewById(R.id.detallePelicula);
        detalle.setText(extras.getString("pe_descripcion").toString());

        id_pelicula = extras.getString("id_pelicula").toString();

        recyclerView = findViewById(R.id.recyclerviewidHorario);
        img= findViewById(R.id.imgPelicula);
        options =new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(extras.getString("pe_imag").toString()).apply(options).into(img);
        jsonRequest();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void jsonRequest() {

        request = new  JsonArrayRequest(JSON_URL + id_pelicula,new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response){

                JSONObject jsonObject = null;
                System.out.println(response);
                for (int i = 0; i< response.length();i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        Calendario calendario = new Calendario();
                        calendario.setFecha(jsonObject.getString("fecha"));
                        calendario.setAsientos( Integer.parseInt(jsonObject.getString("sa_numero_asientos")));
                        calendario.setHora(jsonObject.getString("ca_hora"));
                        calendario.setSala(jsonObject.getString("sa_nombre"));
                        listCalendario.add(calendario);


                    }catch (JSONException ex){
                        ex.printStackTrace();
                    }
                }
                setuprecyclerView(listCalendario);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){


            }
        });

        requestQueue = Volley.newRequestQueue(ScrollingDetalleActivity.this);
        requestQueue.add(request);
    }

    public  void setuprecyclerView(List<Calendario> listCalendario){
        HorarioAdapter myAdapter = new HorarioAdapter(getApplicationContext() , listCalendario);
        System.out.println("Horario"+listCalendario.size());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);

    }
}
