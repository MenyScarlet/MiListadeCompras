package com.example.melania.milistadecompras;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Melania on 07/03/2018.
 */


public class ADialogEliminar extends DialogFragment {

    ListView lvArticulos;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¿Deseas elimninar este producto?")
                .setTitle("ELIMINAR")
                .setPositiveButton("Si", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {

                        dbRef = FirebaseDatabase.getInstance().getReference()
                                .child("articulos");
                        String articulos = lvArticulos.getSelectedItem().toString();

                        dbRef.child(articulos).removeValue(new DatabaseReference.
                                CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference
                                    databaseReference) {

                                if (databaseError == null){

                                    Toast.makeText(getActivity(),
                                            "ELIMINADO CORRECTAMENTE",
                                            Toast.LENGTH_LONG).show();
                                    //limpiarFormulario();

                                }else{

                                    Toast.makeText(getActivity(),
                                            "NO SE PUEDE ELIMINAR EL JUGADOR",
                                            Toast.LENGTH_LONG).show();

                                }

                            }
                        });

                        Toast.makeText(getActivity(), "Eliminado correctamente ",
                                Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Eliminar cancelado",
                                Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

        return builder.create();
    }

    private void limpiarFormulario (View view) {

        //Como se elimina el item entero de un listview?

    }
}
