package com.example.sqliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
    }

    public void goToConsultarDeudas(View view) {
        Intent i = new Intent(this, ConsultarDeudas.class);
        startActivity(i);
    }
}