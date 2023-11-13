package com.example.sqliteconnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.sqliteconnection.R;

import java.util.List;

public class ConsultarDeudas extends AppCompatActivity {
    TableLayout tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_deudas);

        tabla = findViewById(R.id.tablaDeudas);

        listarDeudas();
    }
    public void listarDeudas() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "consorcio", null, 1);
        List<Deuda> list = admin.listarDeudas();
        System.out.println(list);

        TextView tv0 = new TextView(this);
        tv0.setText("DNI");
        TextView tv1 = new TextView(this);
        tv1.setText("Valor");
        TextView tv2 = new TextView(this);
        tv2.setText("Descripcion");

        tv0.setTextSize(30);
        tv1.setTextSize(30);
        tv2.setTextSize(30);

        tv0.setWidth(340);
        tv1.setWidth(360);
        tv2.setWidth(400);

        tv0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        TableRow tr = new TableRow(this);
        tr.addView(tv0);
        tr.addView(tv1);
        tr.addView(tv2);

        tabla.addView(tr);

        for(Deuda d : list) {
            TextView v0 = new TextView(this);
            v0.setText(""+ d.getDni());
            TextView v1 = new TextView(this);
            v1.setText(""+ d.getValor());
            TextView v2 = new TextView(this);
            v2.setText(d.getDetalle());

            v0.setTextSize(24);
            v1.setTextSize(24);
            v2.setTextSize(24);

            v0.setWidth(340);
            v1.setWidth(360);
            v2.setWidth(400);

            v0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            v1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            v2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TableRow tr1 = new TableRow(this);
            tr1.addView(v0);
            tr1.addView(v1);
            tr1.addView(v2);

            tabla.addView(tr1);
        }





    }
}