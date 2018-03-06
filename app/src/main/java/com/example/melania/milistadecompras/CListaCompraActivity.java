package com.example.melania.milistadecompras;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CListaCompraActivity extends AppCompatActivity {

    ListView lvCompra;
    TextView tvSuper;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ArrayList<AArticulo> lista_articulos = new ArrayList<AArticulo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clista_compra);

        tvSuper = (TextView)findViewById(R.id.LcTvSupermercado);
        lvCompra = (ListView)findViewById(R.id.LvListaCompra);

        cargarDatosFirebase();



    }//FIN onCreate

    public void clickVolverMenu (View view){

        Intent i = new Intent(getApplicationContext(),BMenuActivity.class);
        startActivity(i);

        //Dialog ¿Estas seguro que deseas volver al menu sin guardar?

    }

    public void clickListasGuardadas (View view){

        Intent i = new Intent(getApplicationContext(),EListasGuardadasActivity.class);

        startActivity(i);

    }

    public void clickAñadirTienda (View view){

        //Dialogo AÑADIR TIENDA

    }

    public void clickAñadirArticulo (View view){

        Intent i = new Intent(getApplicationContext(),DListaArticulosActivity.class);
        startActivity(i);

        //Esto iria en la Activity de Articulos
        /*FragmentManager fragmentManager = getSupportFragmentManager();
        ADialogRegistroArticulo dialogo = new ADialogRegistroArticulo();

        dialogo.show(fragmentManager, "dialogPersonalizado");*/
    }

    public void clickGuardarLista (View view){

        //Guardar datos en FireBase y en EListasGuardadasActivity
        //Toast se ha guardado correctamente

    }

    private void cargarDatosFirebase(){

        dbRef = FirebaseDatabase.getInstance().getReference().child("articulos");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista_articulos.clear();//Importante para la carga de datos en TIEMPO REAL
                //Quita la antigua lista para cargar una nueva
                for (DataSnapshot articulosDataSnapshot: dataSnapshot.getChildren()){
                    cargarListView(articulosDataSnapshot);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("CListaCompraActivity","DATABASE ERROR");

            }
        };
        dbRef.addValueEventListener(valueEventListener);//Cargar datos en TIEMPO REAL
    }

    private void cargarListView (DataSnapshot dataSnapshot){

        lista_articulos.add(dataSnapshot.getValue(AArticulo.class));

        AAdaptadorArticulo adaptador = new AAdaptadorArticulo(this,
                lista_articulos);

        lvCompra.setAdapter(adaptador);




    }
}
