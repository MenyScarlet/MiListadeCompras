package com.example.melania.milistadecompras;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CListaCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clista_compra);
    }

    public void clickAñadirArticulo (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        ADialogRegistroArticulo dialogo = new ADialogRegistroArticulo();

        dialogo.show(fragmentManager, "dialogPersonalizado");
    }
}
