package com.example.melania.milistadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EListasGuardadasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elistas_guardadas);
    }

    public void clickHome (View view){

        Intent i = new Intent(getApplicationContext(),BMenuActivity.class);

        startActivity(i);

    }

}
