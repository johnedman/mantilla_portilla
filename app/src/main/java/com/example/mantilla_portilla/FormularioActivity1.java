package com.example.mantilla_portilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class FormularioActivity1 extends AppCompatActivity {

    private EditText etNombre, etPrecio, etImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario1);

        etNombre = findViewById(R.id.et_nombre_formulario);
        etPrecio = findViewById(R.id.et_precio_formulario);
        etImagen = findViewById(R.id.et_imagen_formulario);
    }

    public void clickGuardar(View view){
        String nombre = etNombre.getText().toString();
        Double precio = Double.parseDouble(etPrecio.getText().toString());
        String url = etImagen.getText().toString();

        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setPrecio(precio);
        nuevoProducto.setUrlImagen(url);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    }
}