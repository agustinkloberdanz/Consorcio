package com.example.sqliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AgregarDeudas extends AppCompatActivity {
    EditText dniET, valorET, descripcionET;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_deudas);

        dniET = findViewById(R.id.dniAgregarDeuda);
        valorET = findViewById(R.id.valorAgregarDeuda);
        descripcionET = findViewById(R.id.descripcionAgregarDeudas);
    }

    public void agregarDeuda(View view) {
        Calendar date = Calendar.getInstance();
        String fecha = date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR);

        Deuda deuda = new Deuda(null, Integer.parseInt(dniET.getText().toString()), Double.parseDouble(valorET.getText().toString()), descripcionET.getText().toString(), fecha);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        admin.agregarDeuda(deuda);

        dniET.setText("");
        valorET.setText("");
        descripcionET.setText("");
        Toast.makeText(this, "Se cargo la deuda en la DB", Toast.LENGTH_SHORT).show();
    }



}