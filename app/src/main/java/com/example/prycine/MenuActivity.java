package com.example.prycine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.prycine.adapters.RecyclerViewAdapter;
import com.example.prycine.models.Pelicula;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    private final String JSON_URL="http://192.168.100.6:3000/peliculas";

    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Pelicula> listPelicula;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listPelicula = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonRequest();

    }

    private void jsonRequest() {

        request = new  JsonArrayRequest(JSON_URL,new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response){
                JSONObject jsonObject = null;
                System.out.println(response);
                for (int i = 0; i< response.length();i++){
                    Toast.makeText(getApplicationContext(),"SI CARGO "+ i ,Toast.LENGTH_LONG).show();
                    try{
                        jsonObject = response.getJSONObject(i);
                        Pelicula pelicula = new Pelicula();
                        pelicula.setPe_nombre(jsonObject.getString("pe_nombre"));
                        pelicula.setPe_detalle(jsonObject.getString("pe_detalle"));
                        pelicula.setPe_imagen(jsonObject.getString("pe_imagen"));
                        pelicula.setId_pelicula(jsonObject.getString("id_pelicula"));
                        listPelicula.add(pelicula);

                        System.out.println(jsonObject.getString("pe_nombre"));

                    }catch (JSONException ex){
                            ex.printStackTrace();
                    }
                }
                setuprecyclerView(listPelicula);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){


            }
        });

        requestQueue = Volley.newRequestQueue(MenuActivity.this);
        requestQueue.add(request);
    }

    public  void setuprecyclerView(List<Pelicula> listPeliculas){
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, listPeliculas);
        System.out.println("peliculas a;adidas:"+listPeliculas.size());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);
    }
}
