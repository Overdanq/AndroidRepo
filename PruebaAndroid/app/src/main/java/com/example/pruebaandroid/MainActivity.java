package com.example.pruebaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Declaro Variables que el usuario utilizara
    private EditText usuarioEditText;
    private EditText contrasenaEditText;
    private Spinner spinner;
    private Button btnAbrirMapa; // Botón de abrir mapa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazo las variables con los id correspondientes del activity_main
        usuarioEditText = findViewById(R.id.usuario);
        contrasenaEditText = findViewById(R.id.contrasena);
        spinner = findViewById(R.id.spinnerRoles);
        btnAbrirMapa = findViewById(R.id.btnAbrirMapa); // Enlazamos el botón

        //Arreglo de elementos que apareceran en mi Spinner
        String[] roles = {"Administrador", "Usuario"};
        //Creamos un ArrayAdapter para poblar el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Asignar el ArrayAdapter al Spinner
        spinner.setAdapter(adapter);

        // Configuramos el botón para abrir Google Maps con una ubicación
        btnAbrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double latitud = 40.7128;  //
                double longitud = -74.0060; //

                // Crear una URI de Google Maps para la ubicación
                Uri gmmIntentUri = Uri.parse("geo:" + latitud + "," + longitud + "?q=" + latitud + "," + longitud + "(Ubicación)");

                // Crear un Intent para abrir Google Maps
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                // Verificar si hay una app que puede manejar este Intent
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);  // Iniciar la actividad de Google Maps
                } else {
                    Toast.makeText(MainActivity.this, "No hay una aplicación de mapas instalada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Este método será llamado cuando se haga clic en el botón de login
    public void onClickAcceder(View view) {
        //Declaramos variables para obtener los valores ingresados en los campos
        String user = usuarioEditText.getText().toString().trim();
        String pass = contrasenaEditText.getText().toString().trim();
        String rol = spinner.getSelectedItem().toString();

        //Si esta vacio saltara un Toast
        if (user.isEmpty()) {
            Toast.makeText(this, "El campo de usuario está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.isEmpty()) {
            Toast.makeText(this, "El campo de contraseña está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        //Verifico las credenciales y dependiendo del usuario me enviara a diferentes activities
        if (user.equals("usuario1") && pass.equals("1234") && rol.equals("Usuario")) {
            //Inicio una actividad que se realizará en la clase AccesoActivity
            Intent intent = new Intent(this, AccesoActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}
