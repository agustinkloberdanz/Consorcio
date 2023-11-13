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

public class MainActivity extends AppCompatActivity {

    TextView deudaET;
    EditText dniET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deudaET = (TextView) findViewById(R.id.deuda);
        dniET = findViewById(R.id.dni);

//        llenarDB();

    }

    public void llenarDB() {
        cargarUsuario(44860530, "44860530", true);
        cargarUsuario(12345678, "12345678", false);
        cargarUsuario(87654321, "87654321", false);
        cargarUsuario(11112222, "11112222", false);
        cargarUsuario(24082408, "24082408", false);

        cargarDeuda(44860530, 1500.0, "Servicio1");
        cargarDeuda(44860530, 2500.0, "Servicio2");
        cargarDeuda(44860530, 5500.0, "Servicio3");
        cargarDeuda(12345678, 1500.0, "Servicio1");
        cargarDeuda(12345678, 2500.0, "Servicio2");
        cargarDeuda(87654321, 1500.0, "Servicio1");
        cargarDeuda(87654321, 2500.0, "Servicio2");
        cargarDeuda(87654321, 5500.0, "Servicio3");


        Toast.makeText(this, "Se cargaron los usuarios en la DB", Toast.LENGTH_SHORT).show();
    }

    public void cargarUsuario(int dni, String password, Boolean administrador) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("dni", dni);
        registro.put("password", password);
        registro.put("admin", administrador);
        bd.insert("users", null, registro);
        bd.close();
    }

    public void cargarDeuda(int dni, Double valor, String detalle) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("dni", dni);
        registro.put("valor", valor);
        registro.put("detalle", detalle);
        bd.insert("deudas", null, registro);
        bd.close();
    }

    public void consultarDeuda(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String dni = dniET.getText().toString();
        Cursor cursor = bd.rawQuery("SELECT * FROM deudas WHERE dni=" + dni, null);

        double deuda = 0;
        if (cursor.moveToFirst()) {
            do {
                deuda += cursor.getDouble(1);
            } while(cursor.moveToNext());
        }

        deudaET.setText("$" + deuda);
        dniET.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        bd.close();
    }
}