package com.example.prycine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONStringer;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    EditText editUsuario, edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsuario= findViewById(R.id.edtUsuario);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario("http://192.168.100.6:3000/usuario/login/"+editUsuario.getText().toString()+"/"+edtPassword.getText().toString());
            }
        });
    }




    private void validarUsuario(String url){
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        if(!response.isEmpty()){
                            if(response.toString().contains("TRUE")){
                                Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(MainActivity.this,"Usuario y contrase;a incorrecta",Toast.LENGTH_LONG).show();

                            }
                        }else{
                            Toast.makeText(MainActivity.this,"Usuario y contrase;a incorrecta",Toast.LENGTH_LONG).show();

                        }
                        System.out.println(response);
                     //   textView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                Toast.makeText(MainActivity.this,"Mal",Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
