package com.example.pruebaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class VentanaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana);

        // Encuentra el botón en el layout
        Button btnOpenYouTube = findViewById(R.id.btnOpenYouTube);

        // Establece el listener del botón
        btnOpenYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL del video de YouTube (reemplaza esta URL por la del video que deseas mostrar)
                String videoUrl = "https://www.youtube.com/watch?v=tYSo0LsHhvo";  // URL de ejemplo

                // Crea un Intent para abrir el video de YouTube en el navegador o la app de YouTube
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));

                // Inicia el Intent
                startActivity(intent);
            }
        });
    }
}
