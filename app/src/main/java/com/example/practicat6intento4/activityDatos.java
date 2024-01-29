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
        tituloPeli = findViewById(R.id.textTituloSerie);
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

        } else if(titulo.equals("Fargo")) {
            directorPeli.setText("Joel Coen, Ethan Coen");
            repartoPeli.setText("Frances McDormand, William H. Macy, Steve Buscemi");
            clasificacionPeli.setText("4.5/5");
            sinopsisPeli.setText("La película Fargo sigue la historia de un hombre que contrata a dos criminales para secuestrar a su esposa con el fin de obtener un rescate. Sin embargo, las cosas toman un giro inesperado cuando la policía local se involucra en la investigación, desencadenando una serie de eventos violentos y cómicos en el gélido paisaje de Minnesota.");
        } else if(titulo.equals("Karate a Muerte en Bangkok")) {
            directorPeli.setText("Wei Lo");
            repartoPeli.setText("Bruce Lee, Maria Yi, James Tien");
            clasificacionPeli.setText("3/5");
            sinopsisPeli.setText("Bruce Lee interpreta a un maestro de artes marciales que viaja a Bangkok para ayudar a su primo y luchar contra una red criminal que explota a la comunidad local.");
        } else if(titulo.equals("Infiltrados en Clase")){
            directorPeli.setText("Phil Lord, Christopher Miller");
            repartoPeli.setText("Jonah Hill, Channing Tatum, Ice Cube");
            clasificacionPeli.setText("4/5");
            sinopsisPeli.setText("Dos oficiales de policía encubiertos se infiltran en una escuela secundaria para desmantelar una red de drogas. A medida que asumen identidades de estudiantes, se encuentran con situaciones cómicas y desafíos inesperados mientras intentan cumplir su misión.");
        }

        imagenPortada.setOnClickListener(view -> {

            Intent intent = new Intent(activityDatos.this, activityPortada.class);
            intent.putExtra("idImagen", idImagen);
            startActivity(intent);
        });

    }


}