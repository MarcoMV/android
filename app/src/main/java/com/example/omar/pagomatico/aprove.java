package com.example.omar.pagomatico;

import android.app.Activity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by OMAR on 11/04/2015.
 */
public class aprove extends Activity {

    AlertDialog.Builder msj;
    String telefono;
    Button accionenv;
    EditText registroq;

    String TEST_URL = "http://requestb.in/139ap2g1";
    String BASE_URL = "http://15b73f58.ngrok.com";
    String AUTH_SUFFIX = "/api/v1/charges/request_credit";
    String auxResponse="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_verif);
        enviarNext();
    }
    private void enviarNext() {
        Button accionenv = (Button) findViewById(R.id.btnVer);
        accionenv.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                PostDatos();



            }
        });

    }

    private void PostDatos() {


        registroq = (EditText) findViewById(R.id.Tel);
        telefono=registroq.getText().toString();
        accionenv = (Button) findViewById(R.id.enviarNext);

        final ProgressDialog progressDialog = ProgressDialog.show(aprove.this, "Espera", "Estamos procesando");
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("phone", telefono);
        RequestQueue mRequestQueue = Volley.newRequestQueue(aprove.this);


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


                                startActivity(new Intent(aprove.this, pantalla_2.class));



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


    public ArrayList<cargos> parser (JSONArray response){
        ArrayList<cargos> cargoAux=new ArrayList<cargos>();

        for (int i=0;i<response.length();i++){
            cargos com =new cargos();
            try {
                JSONObject jsonObject= (JSONObject) response.get(i);

                com.setProducto(jsonObject.getString("nombre"));
                com.setTelefono(jsonObject.getString("descripcion"));
                com.setProducto(jsonObject.getString("tipo"));
                com.setSemanas(jsonObject.getString("seamanas"));
                Log.e("DATO: ", com.getTelefono().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return null;

    }

}
