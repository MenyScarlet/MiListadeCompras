package com.example.melania.milistadecompras;

/**
 * Created by Melania on 04/03/2018.
 */
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


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

        if(articulos.get(position).getCategoria().equals("Pescado")){
           // item.setBackground(R.drawable.fondo_cat_pescado);
            item.setBackgroundColor(Color.BLUE);
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

        //GetPrecio (revisar si algo sale mal)***********************
        Double precio;
        TextView tvPrecio = (TextView)
                item.findViewById(R.id.LcTvPrecio);

        tvPrecio.setText(articulos.get(position).getPrecio() + "");

        return item;
    }
}
