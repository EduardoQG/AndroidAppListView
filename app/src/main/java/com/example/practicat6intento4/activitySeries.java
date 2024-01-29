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

        if(titulo.equals("Me Llamo Earl")) {
            directorSerie.setText("Gregory Thomas Garcia");
            repartoSerie.setText("Jason Lee, Ethan Suplee, Jaime Pressly");
            clasificacionSerie.setText("4/5");
            sinopsisSerie.setText("Earl Hickey, un delincuente redimido, realiza una lista de todas las malas acciones que ha cometido en su vida y se propone corregirlas una por una para enmendar su karma.");
            temporadasSerie.setText("4");
        } else if(titulo.equals("Seinfield")) {
            directorSerie.setText("Larry David, Jerry Seinfeld");
            repartoSerie.setText("Jerry Seinfeld, Julia Louis-Dreyfus, Jason Alexander, Michael Richards");
            clasificacionSerie.setText("5/5");
            sinopsisSerie.setText("La serie 'Seinfeld' sigue la vida cotidiana y las experiencias cómicas del comediante Jerry Seinfeld y sus amigos en la ciudad de Nueva York.");
            temporadasSerie.setText("9");
        } else if(titulo.equals("Six Feet Under")) {
            directorSerie.setText("Alan Ball");
            repartoSerie.setText("Peter Krause, Michael C. Hall, Frances Conroy");
            clasificacionSerie.setText("4.5/5");
            sinopsisSerie.setText("Sigue la vida de la familia Fisher, propietaria de una funeraria en Los Ángeles. Cada episodio comienza con la muerte de un individuo y explora cómo la familia Fisher enfrenta la vida, la muerte y sus propios conflictos personales.");
            temporadasSerie.setText("5");
        } else if(titulo.equals("Bojack Horseman")) {
            directorSerie.setText("Raphael Bob-Waksberg");
            repartoSerie.setText("Will Arnett, Amy Sedaris, Alison Brie");
            clasificacionSerie.setText("4.5/5");
            sinopsisSerie.setText("Sigue la vida de BoJack, un caballo antropomórfico y ex estrella de televisión, mientras navega por la industria del entretenimiento, la fama y la búsqueda de significado en su vida.");
            temporadasSerie.setText("6");
        }

        imagenPortada.setOnClickListener(view -> {

            Intent intent = new Intent(activitySeries.this, activityPortada.class);
            intent.putExtra("idImagen", idImagen);
            startActivity(intent);
        });

    }
}