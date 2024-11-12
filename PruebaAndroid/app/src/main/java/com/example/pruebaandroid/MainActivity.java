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
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usuarioEditText;
    private EditText contrasenaEditText;
    private Spinner spinner;
    private Button btnAbrirMapa;
    private Button btnAbrirVideo;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById(R.id.usuario);
        contrasenaEditText = findViewById(R.id.contrasena);
        spinner = findViewById(R.id.spinnerRoles);
        btnAbrirMapa = findViewById(R.id.btnAbrirMapa);
        btnAbrirVideo = findViewById(R.id.btnAbrirVideo);
        webView = findViewById(R.id.webview);

        String[] roles = {"Administrador", "Usuario"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnAbrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitud = 40.7128;
                double longitud = -74.0060;
                Uri gmmIntentUri = Uri.parse("geo:" + latitud + "," + longitud + "?q=" + latitud + "," + longitud + "(Ubicación)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(MainActivity.this, "No hay una aplicación de mapas instalada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configura el botón para abrir el video de YouTube después de iniciar sesión
        btnAbrirVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoId = "ID_DEL_VIDEO"; // Reemplaza con el ID del video
                String embedUrl = "https://www.youtube.com/embed/" + videoId;
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.loadUrl(embedUrl);
            }
        });
    }

    public void onClickAcceder(View view) {
        String user = usuarioEditText.getText().toString().trim();
        String pass = contrasenaEditText.getText().toString().trim();
        String rol = spinner.getSelectedItem().toString();

        if (user.isEmpty()) {
            Toast.makeText(this, "El campo de usuario está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.isEmpty()) {
            Toast.makeText(this, "El campo de contraseña está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if (user.equals("usuario1") && pass.equals("1234") && rol.equals("Usuario")) {
            Intent intent = new Intent(this, AccesoActivity.class);
            startActivity(intent);
            btnAbrirVideo.setVisibility(View.VISIBLE);  // Muestra el botón de video después de iniciar sesión correctamente
        } else {
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}

