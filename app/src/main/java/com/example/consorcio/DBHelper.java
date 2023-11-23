package com.example.consorcio;

import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DBHelper {
    public void insert(Deuda deuda) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbref = db.getReference(Deuda.class.getSimpleName());

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dbref.push().setValue(deuda);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void delete(Deuda deuda) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbref = db.getReference(Deuda.class.getSimpleName());

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()) {
                    int dni = Integer.parseInt(ds.child("dni").getValue().toString());
                    Double valor = Double.parseDouble(ds.child("valor").getValue().toString());
                    String detalle = ds.child("detalle").getValue().toString();
                    String fecha = ds.child("fecha").getValue().toString();
                    String depto = ds.child("depto").getValue().toString();
                    String referencia = ds.child("referencia").getValue().toString();
                    Deuda deudaAux = new Deuda(dni, valor, detalle, fecha, referencia, depto);

                    if(deuda.equals(deudaAux)) {
                        ds.getRef().removeValue();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
