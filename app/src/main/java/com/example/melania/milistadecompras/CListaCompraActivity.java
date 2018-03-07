package com.example.melania.milistadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CListaCompraActivity extends AppCompatActivity {

    ListView lvCompra;
    EditText etSuper;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ArrayList<AArticulo> lista_articulos = new ArrayList<AArticulo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clista_compra);

        etSuper = (EditText) findViewById(R.id.LcEtSupermercado);
        lvCompra = (ListView)findViewById(R.id.LvListaCompra);

        cargarDatosFirebase();

        etSuper.setEnabled(false);




    }//FIN onCreate

    public void clickVolverMenu (View view){

        Intent i = new Intent(getApplicationContext(),BMenuActivity.class);
        startActivity(i);

        //Dialog ¿Estas seguro que deseas volver al menu sin guardar?

    }

    public void clickListasGuardadas (View view){

        Intent i = new Intent(getApplicationContext(),EListasGuardadasActivity.class);

        startActivity(i);

        //Dialog ¿Estas seguro que deseas ir a las Listas Guardadas sin guardar?

    }

    public void clickAñadirTienda (View view){

        etSuper.setEnabled(true);

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

        String supermercado = etSuper.getText().toString();

        //Guardar datos en FireBase y en EListasGuardadasActivity
        //Toast se ha guardado correctamente

        if (supermercado.equals("")){

            Toast.makeText(getApplicationContext(),
                    "Debes de añadir un supermercado o darle un nombre a la lista",
                    Toast.LENGTH_LONG).show();

        }else {

            /*AArticulo nuevaLista = new AArticulo(supermercado);
            dbRef = FirebaseDatabase.getInstance().getReference().child("jugadores");

            dbRef.child("").setValue(nuevaLista, new DatabaseReference.CompletionListener() {

                public void onComplete(DatabaseError error, DatabaseReference ref) {

                    if (error == null) {

                        Toast.makeText(getApplicationContext(), "GUARDADO CORRECTAMENTE",
                                Toast.LENGTH_LONG).show();


                    } else {

                        Toast.makeText(getApplicationContext(), "NO SE HA PODIDO GUARDAR LA LISTA",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });*/

        }

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

        AAdaptadorCompra adaptador = new AAdaptadorCompra(this,
                lista_articulos);

        lvCompra.setAdapter(adaptador);




    }
}
