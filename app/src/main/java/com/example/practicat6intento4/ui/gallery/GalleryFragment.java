package com.example.practicat6intento4.ui.gallery;

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
import com.example.practicat6intento4.activitySeries;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private ArrayList<ListItem> elementosSeries;
    private MyAdapter seriesAdapter;
    private ListView listaSeries;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        listaSeries = root.findViewById(R.id.miListaSeries);

        cargarDatosSeries();

        return root;
    }

    public void onResume() {
        super.onResume();

        cargarDatosSeries();
    }

    private void cargarDatosSeries() {
        elementosSeries = new ArrayList<>();
        elementosSeries.add(new ListItem("Me Llamo Earl", R.drawable.mellamoearl));
        elementosSeries.add(new ListItem("Seinfield", R.drawable.seinfield));
        elementosSeries.add(new ListItem("Six Feet Under", R.drawable.sixfeet));
        elementosSeries.add(new ListItem("Bojack Horseman", R.drawable.bojack));
        seriesAdapter = new MyAdapter(requireContext(), R.layout.list_item, elementosSeries);
        listaSeries.setAdapter(seriesAdapter);
        listaSeries.setOnItemClickListener((adapterView, view, position, id) -> {

            ListItem clickedItem = elementosSeries.get(position);
            String itemName = clickedItem.getTexto();
            Intent intent = new Intent(requireContext(), activitySeries.class);
            intent.putExtra("titulo", itemName);
            intent.putExtra("idImagen", clickedItem.getImagenId());
            startActivity(intent);
        });
    }
}