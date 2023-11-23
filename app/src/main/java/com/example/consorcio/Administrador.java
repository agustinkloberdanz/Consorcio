package com.example.consorcio;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            User user = new User(44860530, "44860530", true);
            if (user != null) {
                User userCheck = new User(Integer.parseInt(usr.getText().toString().trim()), pass.getText().toString().trim(), user.getAdmin());

                if (user.equals(userCheck)) {
                    goToConsultarDeudas();
                } else {
                    Toast.makeText(Administrador.this, "Datos de administrador incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }
        usr.setText("");
        pass.setText("");
    }
    public void goToConsultarDeudas() {
        Intent i = new Intent(this, ConsultarDeudas.class);
        startActivity(i);
    }
}