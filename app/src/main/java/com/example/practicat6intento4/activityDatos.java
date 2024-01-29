package com.example.practicat6intento4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activityDatos extends AppCompatActivity {

    ImageView imagenPortada;
    TextView tituloPeli, directorPeli, repartoPeli, clasificacionPeli, sinopsisPeli;
    String titulo;
    int idImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        imagenPortada = findViewById(R.id.imageViewSerie);
        tituloPeli = findViewById(R.id.textTituloPeli);
        directorPeli = findViewById(R.id.textDirectorSerie);
        repartoPeli = findViewById(R.id.textRepartoSerie);
        clasificacionPeli = findViewById(R.id.textClasificacionSerie);
        sinopsisPeli = findViewById(R.id.textSinopsisSerie);

        Bundle extras = getIntent().getExtras();
        titulo = extras.getString("titulo");
        idImagen = extras.getInt("idImagen");
        imagenPortada.setImageResource(idImagen);
        tituloPeli.setText(titulo);

        if(titulo.equals("Ciudad de Dios")) {
            directorPeli.setText("Fernando Meirelles");
            repartoPeli.setText("Alexandre Rodrigues, Leandro Firmino da Hora, Phellipe Haagensen");
            clasificacionPeli.setText("5/5");
            sinopsisPeli.setText("La película narra la vida en la favela de Ciudad de Dios desde finales de los años 60 hasta principios de los 80. Se centra en la historia de Rocket, un joven fotógrafo que intenta documentar la brutalidad y la violencia que rodea su vida en la favela.");

        }

        imagenPortada.setOnClickListener(view -> {

            Intent intent = new Intent(activityDatos.this, activityPortada.class);
            intent.putExtra("idImagen", idImagen);
            startActivity(intent);
        });

    }
}