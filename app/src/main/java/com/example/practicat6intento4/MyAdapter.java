package com.example.practicat6intento4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class MyAdapter extends BaseAdapter
{
    Context contexto;
    int distribucion;
    ArrayList<ListItem> elementos;

    TextView textView;
    public MyAdapter(Context context, int layout, ArrayList<ListItem> items)
    {
        this.contexto = context;
        this.distribucion = layout;
        this.elementos = items;
    }
    @Override
    public int getCount()
    {
        return this.elementos.size();
    }
    @Override
    public Object getItem(int i)
    {
        return this.elementos.get(i);
    }
    @Override
    public long getItemId(int i)
    {
        return i;
    }
    @Override
    // Este método se llama una vez por cada elemento del ArrayList
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        // Copiamos la vista
        View v = view;
        // Inflamos la vista con nuestra propia distribución
        LayoutInflater layoutInflater = LayoutInflater.from(this.contexto);
        v = layoutInflater.inflate(R.layout.list_item, null);

        ListItem currentItem = elementos.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        textView = v.findViewById(R.id.textView);
        textView.setText(currentItem.getTexto());

        ImageView imageView = v.findViewById(R.id.imageView);
        imageView.setImageResource(currentItem.getImagenId());
        // Devolvemos la vista inflada, rellena
        return v;
    }
}

