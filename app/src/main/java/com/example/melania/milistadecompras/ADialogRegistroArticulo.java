package com.example.melania.milistadecompras;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Melania on 04/03/2018.
 */

public class ADialogRegistroArticulo extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View viewLayout = inflater.inflate(R.layout.dialog_registro_articulo,null);
        builder.setView(viewLayout)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText etNombre = (EditText) viewLayout.findViewById(R.id.RegisEtNombre);
                        String nombre = etNombre.getText().toString();

                        EditText etMarca = (EditText) viewLayout.findViewById(R.id.RegisEtMarca);
                        String marca = etMarca.getText().toString();

                        EditText etMercado = (EditText) viewLayout.findViewById(R.id.RegisEtMercado);
                        String mercado = etMercado.getText().toString();

                        Spinner spCategoria = (Spinner) viewLayout.findViewById(R.id.RegisSpCategoria);
                        String categoria = spCategoria.getSelectedItem().toString();

                        EditText etPrecio = (EditText) viewLayout.findViewById(R.id.RegisEtPrecio);
                        String precio = etPrecio.getText().toString();




                        Toast.makeText(getActivity(),
                                "El producto se ha guerdado correctamente",
                                Toast.LENGTH_SHORT).show();

                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
