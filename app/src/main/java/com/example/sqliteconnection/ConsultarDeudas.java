package com.example.sqliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ConsultarDeudas extends AppCompatActivity {
    TableLayout tabla;
    Button agregarButton;

    @Override
    protected void onStart() {
        super.onStart();
        listarDeudas();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_deudas);

        agregarButton = findViewById(R.id.agregarDeudaViewButton);
        agregarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAgregarDeudas();
            }
        });

        tabla = findViewById(R.id.tablaDeudas);
    }

    public void listarDeudas() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        List<Deuda> list = admin.listarDeudas();

        tabla.removeAllViews();

        TextView th0 = new TextView(this);
        th0.setText("DNI");
        TextView th1 = new TextView(this);
        th1.setText("Valor");
        TextView th2 = new TextView(this);
        th2.setText("Detalle");
        TextView th3 = new TextView(this);
        th3.setText("Fecha");

        th0.setTextSize(20);
        th1.setTextSize(20);
        th2.setTextSize(20);
        th3.setTextSize(20);

        th0.setBackgroundColor(Color.parseColor("#a200ff"));
        th1.setBackgroundColor(Color.parseColor("#a200ff"));
        th2.setBackgroundColor(Color.parseColor("#a200ff"));
        th3.setBackgroundColor(Color.parseColor("#a200ff"));

        th0.setWidth(245);
        th1.setWidth(245);
        th2.setWidth(245);
        th3.setWidth(245);

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

        for(Deuda d : list) {
            TextView tb0 = new TextView(this);
            tb0.setText(""+ d.getDni());
            TextView tb1 = new TextView(this);
            tb1.setText("$"+ d.getValor());
            TextView tb2 = new TextView(this);
            tb2.setText(d.getDetalle());
            TextView tb3 = new TextView(this);
            tb3.setText(d.getFecha());
            TextView btn = new TextView(this);
            btn.setText("-");

            tb0.setTextSize(18);
            tb1.setTextSize(18);
            tb2.setTextSize(18);
            tb3.setTextSize(18);
            btn.setTextSize(18);

            tb0.setWidth(245);
            tb1.setWidth(245);
            tb2.setWidth(245);
            tb3.setWidth(245);
            btn.setWidth(100);
            btn.setHeight(100);
            btn.setBackgroundColor(Color.parseColor("#ff0000"));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eliminarDeuda(d.getId());
                }
            });

            tb0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tb1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tb2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tb3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            btn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TableRow tr1 = new TableRow(this);
            tr1.addView(tb0);
            tr1.addView(tb1);
            tr1.addView(tb2);
            tr1.addView(tb3);
            tr1.addView(btn);

            tabla.addView(tr1);

            TableRow trTab = new TableRow(this);
            trTab.setBackgroundColor(Color.parseColor("#ffffff"));
            trTab.setMinimumHeight(1);

            tabla.addView(trTab);
        }
    }
    public void eliminarDeuda(int id) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        admin.eliminarDeuda(id);
        Toast.makeText(this, "Se elimino la deuda en la DB", Toast.LENGTH_SHORT).show();

        listarDeudas();
    }
    public void goToAgregarDeudas() {
        Intent i = new Intent(this, AgregarDeudas.class);
        startActivity(i);
    }
}