package com.example.melania.milistadecompras;

/**
 * Created by Melania on 04/03/2018.
 */
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import static com.example.melania.milistadecompras.R.drawable.fondo_cat_pescado;


public class AAdaptadorCompra extends ArrayAdapter<AArticulo> {
    ArrayList<AArticulo> articulos;
    Context c;
    public AAdaptadorCompra(Context c, ArrayList<AArticulo> articulos) {
        super(c, R.layout.item_producto, articulos);
        this.articulos = articulos;
        this.c = c;
    }
    public View getView(int position, View view, ViewGroup
            viewGroup) {
        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_producto, null);

        if(articulos.get(position).getCategoria().equals("Carne")){
            //item.setBackgroundDrawable(R.drawable.fondo_cat_pescado);
            item.setBackgroundColor(Color.RED);
        }

        if(articulos.get(position).getCategoria().equals("Pescado")){
            //item.setBackgroundDrawable(R.drawable.fondo_cat_pescado);
            item.setBackgroundColor(Color.BLUE);
        }

        if(articulos.get(position).getCategoria().equals("Verduras")){
            //item.setBackgroundDrawable(R.drawable.fondo_cat_pescado);
            item.setBackgroundColor(Color.GREEN);
        }

        if(articulos.get(position).getCategoria().equals("Frutas")){
           //item.setBackgroundDrawable(R.drawable.fondo_cat_pescado);
            item.setBackgroundColor(Color.RED);
        }
        //GetNombre
        TextView tvNombre = (TextView)
                item.findViewById(R.id.LcTvNombre);
        tvNombre.setText(articulos.get(position).getNombre() );
        //GetMarca
        TextView tvMarca = (TextView)
                item.findViewById(R.id.LcTvMarca);
        tvMarca.setText(articulos.get(position).getMarca() );

        //GetMercado
        TextView tvCategoria = (TextView)
                item.findViewById(R.id.LcTvCategoria);
        tvCategoria.setText(articulos.get(position).getCategoria() );

        if (articulos.get(position).getCategoria().equals("Pescasdo")) {
            //tvCategoria.setBackground(R.drawable.fondo_cat_pescado);
        }
        //GetPrecio (revisar si algo sale mal)***********************
        Double precio;
        TextView tvPrecio = (TextView)
                item.findViewById(R.id.LcTvPrecio);

        tvPrecio.setText(articulos.get(position).getPrecio() + "" + " €");

        return item;
    }
}
