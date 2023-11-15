package com.example.sqliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Propietario extends AppCompatActivity {

    EditText dniET;
    TableLayout tabla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propietario);
        dniET = findViewById(R.id.dni);

        tabla = findViewById(R.id.listDeudas);
    }

    public void listarDeudas(View view) {
        if(dniET.getText().toString() != null) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
            List<Deuda> list = admin.listarDeudasPorDni(Integer.parseInt(dniET.getText().toString()));

            tabla.removeAllViews();

            TextView th0 = new TextView(this);
            th0.setText("DNI");
            TextView th1 = new TextView(this);
            th1.setText("Valor");
            TextView th2 = new TextView(this);
            th2.setText("Detalle");
            TextView th3 = new TextView(this);
            th3.setText("Fecha");

            th0.setTextSize(24);
            th1.setTextSize(24);
            th2.setTextSize(24);
            th3.setTextSize(24);

            th0.setBackgroundColor(Color.parseColor("#a200ff"));
            th1.setBackgroundColor(Color.parseColor("#a200ff"));
            th2.setBackgroundColor(Color.parseColor("#a200ff"));
            th3.setBackgroundColor(Color.parseColor("#a200ff"));

            th0.setWidth(280);
            th1.setWidth(280);
            th2.setWidth(280);
            th3.setWidth(280);

            th0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            th1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            th2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            th3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TableRow tr0 = new TableRow(this);
            tr0.addView(th0);
            tr0.addView(th1);
            tr0.addView(th2);
            tr0.addView(th3);

            tabla.addView(tr0);

            for (Deuda d : list) {
                TextView tb0 = new TextView(this);
                tb0.setText("" + d.getDni());
                TextView tb1 = new TextView(this);
                tb1.setText("$" + d.getValor());
                TextView tb2 = new TextView(this);
                tb2.setText(d.getDetalle());
                TextView tb3 = new TextView(this);
                tb3.setText(d.getFecha());

                tb0.setTextSize(20);
                tb1.setTextSize(20);
                tb2.setTextSize(20);
                tb3.setTextSize(20);

                tb1.setWidth(270);
                tb2.setWidth(270);
                tb3.setWidth(270);
                tb0.setWidth(270);

                tb0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tb1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tb2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tb3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                TableRow tr1 = new TableRow(this);
                tr1.addView(tb0);
                tr1.addView(tb1);
                tr1.addView(tb2);
                tr1.addView(tb3);

                tabla.addView(tr1);

                TableRow trTab = new TableRow(this);
                trTab.setBackgroundColor(Color.parseColor("#ffffff"));
                trTab.setMinimumHeight(1);

                tabla.addView(trTab);
            }
        } else {
            Toast.makeText(this, "Ingrese su DNI si quiere consultar sus deudas", Toast.LENGTH_SHORT).show();
        }
        dniET.setText("");
    }

}