package com.example.mantilla_portilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText etUsuario, etPassword;
    private SharedPreferences misPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        referenciar();

        misPreferencias = getSharedPreferences("tienda_app", MODE_PRIVATE);

        if (misPreferencias.getBoolean("logueado", false)==true){
            Intent miIntent = new Intent(this, MainActivity.class);
            startActivity(miIntent);
            finish();
        }
    }
    private void referenciar(){
        etUsuario = findViewById(R.id.et_usuario_login);
        etPassword = findViewById(R.id.et_password_login);



    }
    public void  clickIniciarSesion (View view){
        String PASS = "12345";
        String USER = "john";

        String passUser = etPassword.getText().toString();
        String userUser = etUsuario.getText().toString();

        if(PASS.equals(passUser)&&USER.equals(userUser)) {

            SharedPreferences.Editor myEditor = misPreferencias.edit();
            myEditor.putBoolean("logueado", true);
            myEditor.apply();

            Intent miIntent = new Intent(this, MainActivity.class);
            startActivity(miIntent);
            finish();
            }else{
                Toast.makeText(this, "CREDENCIALES INCORRECTAS", Toast.LENGTH_SHORT).show();
        }
    }

}