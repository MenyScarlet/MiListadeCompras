package com.example.melania.milistadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmenu);
    }

    public void clickMenuListNew (View view){

        Intent i = new Intent(getApplicationContext(),CListaCompraActivity.class);
        startActivity(i);
    }

    public void clickMenuListSave (View view){

        Intent i = new Intent(getApplicationContext(),EListasGuardadasActivity.class);
        startActivity(i);

    }

    public void clickMenuListItems (View view){

        Intent i = new Intent(getApplicationContext(),DListaArticulosActivity.class);
        startActivity(i);

    }

}
