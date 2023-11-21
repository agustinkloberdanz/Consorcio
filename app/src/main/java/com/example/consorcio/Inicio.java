package com.example.consorcio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


    }

    public void goToPropietario(View view) {
        Intent i = new Intent(this, Propietario.class);
        startActivity(i);
    }

    public void goToAdministrador(View view) {
        Intent i = new Intent(this, Administrador.class);
        startActivity(i);
    }
}