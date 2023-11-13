package com.example.sqliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Propietario extends AppCompatActivity {

    TextView deudaET;
    EditText dniET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propietario);
        deudaET = (TextView) findViewById(R.id.deuda);
        dniET = findViewById(R.id.dni);


    }

    public void consultarDeuda(View v) {
        double deuda = 0;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        List<Deuda> listDeuda = admin.listarDeudasPorDni(Integer.parseInt(dniET.getText().toString()));
        for(Deuda d : listDeuda) {
            deuda += d.getValor();
        }

        deudaET.setText("$" + deuda);
        dniET.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}