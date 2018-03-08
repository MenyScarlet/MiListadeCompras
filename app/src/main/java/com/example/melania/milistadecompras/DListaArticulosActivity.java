package com.example.melania.milistadecompras;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DListaArticulosActivity extends AppCompatActivity {

    ListView lvArticulos;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ArrayList<AArticulo> lista_articulos = new ArrayList<AArticulo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlista_articulos);

        lvArticulos = (ListView)findViewById(R.id.LaLvArticulos);

        cargarDatosFirebase();



    }//FIN onCreate

    public void clickCancelarArticulo (View view){

        Intent i = new Intent(getApplicationContext(),CListaCompraActivity.class);
        startActivity(i);

    }

    public void clickNuevoArticulo (View view){

        FragmentManager fragmentManager = getSupportFragmentManager();
        ADialogRegistroArticulo dialogo = new ADialogRegistroArticulo();

        dialogo.show(fragmentManager, "dialogPersonalizado");

        //dialogo

    }

    public void clickSeleccionarArticulo (View view){

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
                Log.e("CListaArticulosActivity","DATABASE ERROR");

            }
        };
        dbRef.addValueEventListener(valueEventListener);//Cargar datos en TIEMPO REAL
    }

    private void cargarListView (DataSnapshot dataSnapshot){

        lista_articulos.add(dataSnapshot.getValue(AArticulo.class));

        AAdaptadorArticulo adaptador = new AAdaptadorArticulo(this,
                lista_articulos);

        lvArticulos.setAdapter(adaptador);

        lvArticulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        lvArticulos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                ADialogEliminar dialogo = new ADialogEliminar();
                dialogo.show(fragmentManager, "dialogConfirmacino");

                return true;
            }
        });






    }

}
