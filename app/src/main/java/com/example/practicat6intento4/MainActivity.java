package com.example.practicat6intento4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicat6intento4.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    ListView listaPelis;
    ListView listaSeries;
    ArrayList<ListItem> elementos;
    ImageView imagenPortada;
    TextView tituloPeli, directorPeli, repartoPeli, clasificacionPeli, sinopsisPeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listaPelis = findViewById(R.id.miListaPelis);
        listaSeries = findViewById(R.id.miListaSeries);

        // PELICULAS:
        elementos = new ArrayList<ListItem>();
        elementos.add(new ListItem("Ciudad de Dios", R.drawable.ciudaddedios));
        /*
        elementos.add("Cádiz");
        elementos.add("Córdoba");
        elementos.add("Granada");
        elementos.add("Huelva");
        elementos.add("Jaén");
        elementos.add("Málaga");
        elementos.add("Sevilla");
         */

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, elementos);
        // Asignar el adaptador a nuestro ListView
        listaPelis.setAdapter(myAdapter);

        listaPelis.setOnItemClickListener((adapterView, view, position, id) -> {

            ListItem clickedItem = elementos.get(position);
            String itemName = clickedItem.getTexto();
            Intent intent = new Intent(MainActivity.this, activityDatos.class);
            intent.putExtra("titulo", itemName);
            intent.putExtra("idImagen", clickedItem.getImagenId());
            startActivity(intent);
        });

        // SERIES:
        /*
        elementos = new ArrayList<ListItem>();
        elementos.add(new ListItem("Me llamo Earl", R.drawable.mellamoearl));

        elementos.add("Cádiz");
        elementos.add("Córdoba");
        elementos.add("Granada");
        elementos.add("Huelva");
        elementos.add("Jaén");
        elementos.add("Málaga");
        elementos.add("Sevilla");


        // Asignar el adaptador a nuestro ListView
        listaSeries.setAdapter(myAdapter);

        listaSeries.setOnItemClickListener((adapterView, view, position, id) -> {

            ListItem clickedItem = elementos.get(position);
            String itemName = clickedItem.getTexto();
            Intent intent = new Intent(MainActivity.this, activitySeries.class);
            intent.putExtra("titulo", itemName);
            intent.putExtra("idImagen", clickedItem.getImagenId());
            startActivity(intent);
        });
        */

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    protected void onResume() {
        super.onResume();

        // Cargar datos y configurar el menú cada vez que la actividad se reanuda
        cargarDatos();
    }





    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void cargarDatos() {

        elementos = new ArrayList<>();
        elementos.add(new ListItem("Ciudad de Dios", R.drawable.ciudaddedios));

        // Crear un Adaptador
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, elementos);

        // Asignar el adaptador a tu ListView o RecyclerView
        listaPelis.setAdapter(myAdapter);
    }
}