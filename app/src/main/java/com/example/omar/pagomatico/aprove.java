package com.example.omar.pagomatico;

import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.*;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
/**
 * Created by OMAR on 11/04/2015.
 */
public class aprove extends Activity {
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
                startActivity(new Intent(aprove.this, pantalla_2.class));


            }
        });
}}
