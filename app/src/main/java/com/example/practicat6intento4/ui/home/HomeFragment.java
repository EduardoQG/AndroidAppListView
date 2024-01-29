package com.example.practicat6intento4.ui.home;

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

        // Configuración inicial para la lista de películas
        elementosPelis = new ArrayList<>();
        elementosPelis.add(new ListItem("Ciudad de Dios", R.drawable.ciudaddedios));
        pelisAdapter = new MyAdapter(requireContext(), R.layout.list_item, elementosPelis);
        listaPelis.setAdapter(pelisAdapter);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Cargar datos cada vez que el fragmento vuelve a estar en primer plano
        cargarDatosPelis();
    }

    // Método para cargar datos en la lista de películas
    private void cargarDatosPelis() {
        elementosPelis.clear();
        elementosPelis.add(new ListItem("Ciudad de Dios", R.drawable.ciudaddedios));
        // Agregar más elementos si es necesario
        pelisAdapter.notifyDataSetChanged();
    }
}