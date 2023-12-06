package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editNombre = findViewById(R.id.user_name);
        TextView txtSaludo = findViewById(R.id.txt_saludo);
        Button boton = findViewById(R.id.btn_saludar);

        boton.setOnClickListener(v->{
            String nombre = editNombre.getText().toString();
            if(!nombre.isEmpty()) {
                String saludo = getString(R.string.welcome_message,nombre.toUpperCase());
                txtSaludo.setText(saludo);
            }else {
                Toast.makeText(this, R.string.you_must_write_your_name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}