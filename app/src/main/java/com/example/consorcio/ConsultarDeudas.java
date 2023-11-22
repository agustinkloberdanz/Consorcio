package com.example.consorcio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
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
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbref = db.getReference(Deuda.class.getSimpleName());

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tabla.removeAllViews();

                if (snapshot.getChildrenCount() > 0) {
                    TextView th0 = new TextView(ConsultarDeudas.this);
                    th0.setText("DNI");
                    TextView th1 = new TextView(ConsultarDeudas.this);
                    th1.setText("Valor");
                    TextView th2 = new TextView(ConsultarDeudas.this);
                    th2.setText("Referencia");
                    TextView th3 = new TextView(ConsultarDeudas.this);
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

                    TableRow tr0 = new TableRow(ConsultarDeudas.this);
                    tr0.addView(th0);
                    tr0.addView(th1);
                    tr0.addView(th2);
                    tr0.addView(th3);

                    tabla.addView(tr0);
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        int dni = Integer.parseInt(ds.child("dni").getValue().toString());
                        Double valor = Double.parseDouble(ds.child("valor").getValue().toString());
                        String detalle = ds.child("detalle").getValue().toString();
                        String fecha = ds.child("fecha").getValue().toString();
                        String referencia = ds.child("referencia").getValue().toString();
                        String depto = ds.child("depto").getValue().toString();

                        Deuda d = new Deuda(dni, valor, detalle, fecha, referencia, depto);

                        TextView tb0 = new TextView(ConsultarDeudas.this);
                        tb0.setText("" + d.getDni());
                        TextView tb1 = new TextView(ConsultarDeudas.this);
                        tb1.setText("$" + d.getValor());
                        TextView tb2 = new TextView(ConsultarDeudas.this);
                        tb2.setText(d.getReferencia());
                        TextView tb3 = new TextView(ConsultarDeudas.this);
                        tb3.setText(d.getFecha());
                        TextView btn = new TextView(ConsultarDeudas.this);
                        btn.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.iconlist,0);
                        tb0.setTextSize(18);
                        tb1.setTextSize(18);
                        tb2.setTextSize(18);
                        tb3.setTextSize(18);
                        btn.setTextSize(18);

                        tb0.setWidth(245);
                        tb1.setWidth(245);
                        tb2.setWidth(245);
                        tb3.setWidth(245);
                        btn.setHeight(80);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                verDeuda(d);
                            }
                        });

                        tb0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tb1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tb2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tb3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        btn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                        TableRow tr1 = new TableRow(ConsultarDeudas.this);
                        tr1.addView(tb0);
                        tr1.addView(tb1);
                        tr1.addView(tb2);
                        tr1.addView(tb3);
                        tr1.addView(btn);

                        tabla.addView(tr1);

                        TableRow trTab = new TableRow(ConsultarDeudas.this);
                        trTab.setBackgroundColor(Color.parseColor("#ffffff"));
                        trTab.setMinimumHeight(1);

                        tabla.addView(trTab);
                    }
                } else {
                    Toast.makeText(ConsultarDeudas.this, "No hay deudas actualmente", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void eliminarDeuda(Deuda deuda) {
        DBHelper db = new DBHelper();
        db.delete(deuda);
        Toast.makeText(this, "Se elimino la deuda en la DB", Toast.LENGTH_SHORT).show();
    }

    public void verDeuda(Deuda deuda) {
        String msg = "\n\n";
        msg += "DNI: " + deuda.getDni() +"\n\n";
        msg += "Departamento: " + deuda.getDepto() +"\n\n";
        msg += "Valor: " + deuda.getValor() +"\n\n";
        msg += "Referencia: " + deuda.getReferencia() +"\n\n";
        msg += "Detalle: " + deuda.getDetalle() +"\n\n";
        msg += "Fecha: " + deuda.getFecha() +"\n\n";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Más información")
                .setCancelable(true)
                .setMessage(msg)
                .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eliminarDeuda(deuda);
                    }
                })
                .show();
    }

    public void goToAgregarDeudas(View view) {
        Intent i = new Intent(this, AgregarDeudas.class);
        startActivity(i);
    }

}