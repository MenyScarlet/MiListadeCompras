package com.example.melania.milistadecompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Melania on 07/03/2018.
 */

public class AAdaptadorArticulo extends ArrayAdapter<AArticulo> {

    ArrayList<AArticulo> articulos;
    Context c;
    public AAdaptadorArticulo(Context c, ArrayList<AArticulo> articulos) {
        super(c, R.layout.item_lista_insertar_productos, articulos);
        this.articulos = articulos;
        this.c = c;
    }
    public View getView(int position, View view, ViewGroup
            viewGroup) {
        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_lista_insertar_productos, null);

        //GetNombre
        TextView tvNombre = (TextView)
                item.findViewById(R.id.LaTvNombre);
        tvNombre.setText(articulos.get(position).getNombre() );
        //GetMarca
        TextView tvMarca = (TextView)
                item.findViewById(R.id.LaTvMarca);
        tvMarca.setText(articulos.get(position).getMarca() );

        //GetCategoria
        TextView tvCategoria = (TextView)
                item.findViewById(R.id.LaTvCategoria);
        tvCategoria.setText(articulos.get(position).getCategoria() );

        //GetMercado
        TextView tvMercado = (TextView)
                item.findViewById(R.id.LaTvMercado);
        tvMercado.setText(articulos.get(position).getMercado() );

        //GetPrecio (revisar si algo sale mal)***********************
        Double precio;
        TextView tvPrecio = (TextView)
                item.findViewById(R.id.LaTvPrecio);

        tvPrecio.setText(articulos.get(position).getPrecio() + "" + " €");

        return item;
    }
}
