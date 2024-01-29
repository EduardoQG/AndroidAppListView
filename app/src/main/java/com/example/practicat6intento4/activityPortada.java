package com.example.practicat6intento4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class activityPortada extends AppCompatActivity {

    ImageView portada;
    int idImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity_portada);

        portada = findViewById(R.id.portada);

        Bundle extras = getIntent().getExtras();
        idImagen = extras.getInt("idImagen");

        portada.setImageResource(idImagen);
    }
}