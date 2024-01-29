package com.example.practicat6intento4.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.practicat6intento4.ListItem;
import com.example.practicat6intento4.MyAdapter;
import com.example.practicat6intento4.R;
import com.example.practicat6intento4.activityDatos;
import com.example.practicat6intento4.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<ListItem> elementosPelis;
    private MyAdapter pelisAdapter;
    private ListView listaPelis;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listaPelis = root.findViewById(R.id.miListaPelis);

        cargarDatosPelis();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        cargarDatosPelis();
    }

    private void cargarDatosPelis() {
        elementosPelis = new ArrayList<>();
        elementosPelis.add(new ListItem("Ciudad de Dios", R.drawable.ciudaddedios));
        elementosPelis.add(new ListItem("Fargo", R.drawable.fargo));
        elementosPelis.add(new ListItem("Karate a Muerte en Bangkok", R.drawable.karate));
        elementosPelis.add(new ListItem("Infiltrados en Clase", R.drawable.infiltrados));
        pelisAdapter = new MyAdapter(requireContext(), R.layout.list_item, elementosPelis);
        listaPelis.setAdapter(pelisAdapter);
        listaPelis.setOnItemClickListener((adapterView, view, position, id) -> {

            ListItem clickedItem = elementosPelis.get(position);
            String itemName = clickedItem.getTexto();
            Intent intent = new Intent(requireContext(), activityDatos.class);
            intent.putExtra("titulo", itemName);
            intent.putExtra("idImagen", clickedItem.getImagenId());
            startActivity(intent);
        });
    }
}