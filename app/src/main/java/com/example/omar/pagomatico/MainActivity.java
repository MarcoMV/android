package com.example.omar.pagomatico;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;

import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;






public class MainActivity extends ActionBarActivity {

    String TEST_URL = "http://requestb.in/139ap2g1";
    String BASE_URL = "http://15b73f58.ngrok.com";
    String AUTH_SUFFIX = "/api/v1/charges/request_credit";
    String auxResponse;

    AlertDialog.Builder msj;
    String telefono;
    Button accionenv;
    EditText registroq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        registroq = (EditText) findViewById(R.id.registro);
        telefono=registroq.getText().toString();
        accionenv = (Button) findViewById(R.id.botonEnv);




        entrarbtn();



    }

    private void entrarbtn() {
        Button accionenv = (Button) findViewById(R.id.botonEnv);
        accionenv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Espera", "Estamos procesando");
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("phone", telefono);
                RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);


                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(BASE_URL + AUTH_SUFFIX, new JSONObject(params),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    auxResponse=response.toString(12);
                                    VolleyLog.v("Response:%n %s", auxResponse);


                                        msj=new AlertDialog.Builder(null);
                                        msj.setTitle("Felicidades");
                                        msj.setMessage("Ya es usuario activo");
                                        msj.setPositiveButton("Ok", null);
                                        msj.create();
                                        msj.show();


                                        startActivity(new Intent(MainActivity.this, pantalla_2.class));



                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());
                    }
                });
                mRequestQueue.add(jsonObjectRequest);


            }
        });


    }

}




