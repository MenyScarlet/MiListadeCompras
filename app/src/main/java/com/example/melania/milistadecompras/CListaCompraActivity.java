package com.example.melania.milistadecompras;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CListaCompraActivity extends AppCompatActivity {

    ListView lvCompra;
    ArrayList<AArticulo> lista_articulos = new ArrayList<AArticulo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clista_compra);

        cargarDatos();

        lvCompra = (ListView)findViewById(R.id.LvListaCompra);

        AAdaptadorArticulo adaptador = new AAdaptadorArticulo(this,
                lista_articulos);

        lvCompra.setAdapter(adaptador);

    }//FIN onCreate

    public void clickAñadirArticulo (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        ADialogRegistroArticulo dialogo = new ADialogRegistroArticulo();

        dialogo.show(fragmentManager, "dialogPersonalizado");
    }

    private void cargarDatos(){
        lista_articulos.add(new AArticulo("","","","",0,false));
    }
}
