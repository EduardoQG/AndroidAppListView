package com.example.practicat6intento4;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listaPelis = findViewById(R.id.miListaPelis);
        listaSeries = findViewById(R.id.miListaSeries);

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
        // Realizar la carga de datos y configuración del menú aquí

        // Por ejemplo, cargar elementos para el menú de películas
        elementos = new ArrayList<>();
        elementos.add(new ListItem("Ciudad de Dios", R.drawable.ciudaddedios));

        // Crear un Adaptador
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, elementos);

        // Asignar el adaptador a tu ListView o RecyclerView
        listaPelis.setAdapter(myAdapter);
    }
}