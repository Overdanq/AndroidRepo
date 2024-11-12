package com.example.pruebaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

// Declara la clase AccesoActivity que extiende AppCompatActivity.
public class AccesoActivity extends AppCompatActivity {
    // Declaración del VideoView
    private VideoView videoView;

    // Método onCreate, llamado cuando la actividad se crea por primera vez.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Llama al método onCreate de la clase base para inicializar la actividad correctamente.
        super.onCreate(savedInstanceState);
        // Establece el diseño de la actividad con el archivo XML correspondiente (activity_acceso).
        setContentView(R.layout.activity_acceso);

        // Configuración del VideoView
        videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.maclaren;  // Ruta del video en recursos
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Controlador multimedia
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Inicia el video
        videoView.start();
    }

    // Este método será llamado cuando se haga clic en el botón y texto
    public void onClickVentana(View view) {
        // Crea un nuevo Intent, que es una forma de iniciar otra actividad.
        Intent intent = new Intent(this, VentanaActivity.class);
        // Inicia la actividad especificada en el Intent (VentanaActivity).
        startActivity(intent);
    }
}
