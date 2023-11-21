package com.example.consorcio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AgregarDeudas extends AppCompatActivity {
    EditText dniET, valorET, descripcionET, referenciaET, deptoET;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_deudas);

        dniET = findViewById(R.id.dniAgregarDeuda);
        valorET = findViewById(R.id.valorAgregarDeuda);
        descripcionET = findViewById(R.id.descripcionAgregarDeudas);
        referenciaET = findViewById(R.id.referenciaAgregarDeudas);
        deptoET = findViewById(R.id.deptoAgregarDeudas);
    }

    public void agregarDeuda(View view) {
        int dni = Integer.parseInt(dniET.getText().toString().trim());
        double valor = Double.parseDouble(valorET.getText().toString().trim());
        String referencia = referenciaET.getText().toString().trim();
        String descripcion = descripcionET.getText().toString().trim();
        String depto = deptoET.getText().toString().trim();
        Calendar date = Calendar.getInstance();
        String fecha = date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR);

        Deuda deuda = new Deuda(dni, valor, descripcion, fecha, referencia, depto);

        DBHelper db = new DBHelper();
        db.insert(deuda);

        dniET.setText("");
        valorET.setText("");
        descripcionET.setText("");
        referenciaET.setText("");
        deptoET.setText("");
        Toast.makeText(this, "Se cargo la deuda en la DB", Toast.LENGTH_SHORT).show();
    }

}