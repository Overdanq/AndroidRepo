package com.example.pruebaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pruebaandroid.AccesoActivity;
import com.example.pruebaandroid.VentanaActivity;
import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;



public class MainActivity extends AppCompatActivity {

    //Declaro Variables que el usuario utilizara
    private EditText usuarioEditText;
    private EditText contrasenaEditText;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazo las variables con los id correspondientes del activity_main
        usuarioEditText = findViewById(R.id.usuario);
        contrasenaEditText = findViewById(R.id.contrasena);
        spinner = findViewById(R.id.spinnerRoles);
        //Arreglo de elementos que apareceran en mi Spinner
        String[] roles = {"Administrador", "Usuario"};
        //Creamos un ArrayAdapter para poblar el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Asignar el ArrayAdapter al Spinner
        spinner.setAdapter(adapter);
    }

    //Este método será llamado cuando se haga clic en el botón de login tiene que ser el mismo nombre del onClick
    public void onClickAcceder(View view) {
        //Declaramos variables para obtener los valores ingresados en los campos
        String user = usuarioEditText.getText().toString().trim();
        String pass = contrasenaEditText.getText().toString().trim();
        String rol = spinner.getSelectedItem().toString();
        //Si esta vacio saltara un Toast
        if(user.isEmpty()) {
            Toast.makeText(this, "El campo de usuario está vacío", Toast.LENGTH_SHORT).show();
            return;
        }
        //Si esta vacio saltara un Toast
        if(pass.isEmpty()) {
            Toast.makeText(this, "El campo de contraseña está vacío", Toast.LENGTH_SHORT).show();
            return;
        }
        //Verifico las credenciales y dependiendo del usuario me enviara a difentes activitys
        if(user.equals("dani") && pass.equals("1234") && rol.equals("Usuario")) {
            //Inicio una actividad que se realizara en la clase AccesoActivity
            Intent intent = new Intent(this, AccesoActivity.class);
            startActivity(intent);
        }
        //Si nada es valido, saltara una alerta
        else {
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

}
