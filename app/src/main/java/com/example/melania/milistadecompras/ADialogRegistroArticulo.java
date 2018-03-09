package com.example.melania.milistadecompras;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Melania on 04/03/2018.
 */

public class ADialogRegistroArticulo extends DialogFragment {

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View viewLayout = inflater.inflate(R.layout.dialog_registro_articulo,null);

        final EditText etNombre = (EditText) viewLayout.findViewById(R.id.RegisEtNombre);


        final EditText etMarca = (EditText) viewLayout.findViewById(R.id.RegisEtMarca);
        final EditText etMercado = (EditText) viewLayout.findViewById(R.id.RegisEtMercado);
        final EditText etPrecio = (EditText) viewLayout.findViewById(R.id.RegisEtPrecio);
        etPrecio.setText("0");
        final Spinner spCategoria = (Spinner) viewLayout.findViewById(R.id.RegisSpCategoria);

        final String [] categorias = {"Selecciona", "Bebidas", "Carnes", "Cereales y Pan",
                "Derivados de animales", "Dulces y Postres", "Frutas y Frutos secos"
                , "Higiene", "Lacteos", "Legumbres", "Limpieza", "Mariscos",
                "Pasta", "Pescado", "Verduras" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(viewLayout.getContext(),
                android.R.layout.simple_expandable_list_item_1,categorias);

        spCategoria.setAdapter(adapter);


        builder.setView(viewLayout)


                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                         String categoria = spCategoria.getSelectedItem().toString();
                         String stprecio = etPrecio.getText().toString();
                         String nombre = etNombre.getText().toString();
                         String marca = etMarca.getText().toString();
                         String mercado = etMercado.getText().toString();


                        if(nombre.equals("") || categoria.equals("Selecciona")) {

                            Toast.makeText(getActivity(),
                                    "Debes de rellenar los campos obligatorios *",
                                    Toast.LENGTH_LONG).show();

                        }else{

                            double precio = Double.parseDouble(stprecio);

                            AArticulo nuevoArticulo = new AArticulo
                                    (nombre, marca, mercado, categoria, precio);
                            dbRef = FirebaseDatabase.getInstance().getReference().child("articulos");

                             /*String nueva_clave = dbRef().push().setvalue(nuevoArticulo, new DatabaseReference.
                            CompletionListener(){*/
                             dbRef.child(nombre).setValue(nuevoArticulo,
                                     new DatabaseReference.CompletionListener(){

                                 public void onComplete(DatabaseError error, DatabaseReference ref) {

                                     if (error == null) {

                                         Toast.makeText(getActivity(),
                                                 "El producto se ha guardado correctamente",
                                                 Toast.LENGTH_LONG).show();


                                     } else {

                                         Toast.makeText(getActivity(),
                                                 "No se ha podido guardar el articulo",
                                                 Toast.LENGTH_LONG).show();

                                     }
                                 }
                            });


                        }

                        dialog.cancel();
                    }
                });



        return builder.create();
    }
}
