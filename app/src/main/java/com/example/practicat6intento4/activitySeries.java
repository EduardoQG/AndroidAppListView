package com.example.practicat6intento4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activitySeries extends AppCompatActivity {

    ImageView imagenPortada;
    TextView tituloSerie, directorSerie, repartoSerie, clasificacionSerie, sinopsisSerie, temporadasSerie;
    String titulo;
    int idImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        imagenPortada = findViewById(R.id.imageViewSerie);
        tituloSerie = findViewById(R.id.textTituloSerie);
        directorSerie = findViewById(R.id.textDirectorSerie);
        repartoSerie = findViewById(R.id.textRepartoSerie);
        clasificacionSerie = findViewById(R.id.textClasificacionSerie);
        sinopsisSerie = findViewById(R.id.textSinopsisSerie);
        temporadasSerie = findViewById(R.id.textTemporadasSerie);

        Bundle extras = getIntent().getExtras();
        titulo = extras.getString("titulo");
        idImagen = extras.getInt("idImagen");
        imagenPortada.setImageResource(idImagen);
        tituloSerie.setText(titulo);

        if(titulo.equals("Ciudad de Dios")) {
            directorSerie.setText("Gregory Thomas Garcia");
            repartoSerie.setText("Jason Lee, Ethan Suplee, Jaime Pressly");
            clasificacionSerie.setText("4/5");
            sinopsisSerie.setText("Earl Hickey, un delincuente redimido, realiza una lista de todas las malas acciones que ha cometido en su vida y se propone corregirlas una por una para enmendar su karma.");
            temporadasSerie.setText("4");
        }

        imagenPortada.setOnClickListener(view -> {

            Intent intent = new Intent(activitySeries.this, activityPortada.class);
            intent.putExtra("idImagen", idImagen);
            startActivity(intent);
        });

    }
}