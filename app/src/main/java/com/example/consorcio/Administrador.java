package com.example.consorcio;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Administrador extends AppCompatActivity {
    EditText usr, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        usr = findViewById(R.id.userEditText);
        pass = findViewById(R.id.passwordTextText);
    }

    public void validarLogin(View view) {
        if (usr.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
            Toast.makeText(this, "Los campos son requeridos", Toast.LENGTH_SHORT).show();
        } else {

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference dbref = db.getReference(User.class.getSimpleName());

            dbref.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Boolean exist = false;
                    Boolean isAdmin = false;

                    for (DataSnapshot ds : snapshot.getChildren()) {
                        int dni = Integer.parseInt(ds.child("dni").getValue().toString());
                        String password = ds.child("password").getValue().toString();
                        Boolean admin = Boolean.parseBoolean(ds.child("admin").getValue().toString());

                        User user = new User(dni, password, admin);

                        User userCheck = new User(Integer.parseInt(usr.getText().toString().trim()), pass.getText().toString().trim(), user.getAdmin());

                        System.out.println(user);
                        System.out.println(userCheck);

                        if (user.equals(userCheck)) {
                            exist = true;

                            if(user.getAdmin()) {
                                isAdmin = true;
                            }
                            break;
                        }
                    }

                    if (exist) {
                        if (isAdmin) {
                            goToConsultarDeudas();
                        } else {
                            Toast.makeText(Administrador.this, "El usuario ingresado no es administrador", Toast.LENGTH_SHORT).show();
                        }
                        usr.setText("");
                        pass.setText("");
                    } else {
                        Toast.makeText(Administrador.this, "Datos de administrador incorrectos", Toast.LENGTH_SHORT).show();
                        usr.setText("");
                        pass.setText("");
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    //    public void validarLogin(View view) {
//        if (usr.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
//            Toast.makeText(this, "Los campos son requeridos", Toast.LENGTH_SHORT).show();
//        } else {
//            User user = new User(44860530, "44860530", true);
//            if (user != null) {
//                User userCheck = new User(Integer.parseInt(usr.getText().toString().trim()), pass.getText().toString().trim(), user.getAdmin());
//
//                if (user.equals(userCheck)) {
//                    goToConsultarDeudas();
//                } else {
//                    Toast.makeText(Administrador.this, "Datos de administrador incorrectos", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//        usr.setText("");
//        pass.setText("");
//    }
    public void goToConsultarDeudas() {
        Intent i = new Intent(this, ConsultarDeudas.class);
        startActivity(i);
    }
}