package com.example.mantilla_portilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> ListaPrincipalProductos = new ArrayList<>();
    private RecyclerView rvListadoProductos;
    private AdaptadorPersonalizado miAdaptador;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.listado));
        setTitle(getString(R.string.txt_detalle));
        cargarDatos();

        rvListadoProductos = findViewById(R.id.rv_listado_productos);
        miAdaptador = new AdaptadorPersonalizado(ListaPrincipalProductos);
        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Producto miProducto, int posicion) {

                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("producto", miProducto);
                startActivity(intent);
            }

            @Override
            public void onItemBtnEliminaClick(Producto miProducto, int posicion) {

            }
        });

        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(ListaPrincipalProductos);

        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Producto miProducto, int posicion) {

                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("producto", miProducto);
                startActivity(intent);

            }

            @Override
            public void onItemBtnEliminaClick(Producto miProducto, int posicion) {
                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                firestore.collection("productos").document(miProducto.getId());
                ListaPrincipalProductos.remove(posicion);
                miAdaptador.setListadoInformacion(ListaPrincipalProductos);

            }
        });

        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void cargarDatos(){

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("productos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for (DocumentSnapshot document: task.getResult()) {
                        Producto productoAtrapado = document.toObject(Producto.class);
                        productoAtrapado.setId(document.getId());
                        ListaPrincipalProductos.add(productoAtrapado);

                    }
                    miAdaptador.setListadoInformacion(ListaPrincipalProductos);
                }else{
                    Toast.makeText(MainActivity.this, "NO se pudo conectar al servidor", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void clickCerrarSesion(View view){
        SharedPreferences misPreferencias = getSharedPreferences("tienda_app", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = misPreferencias.edit();
        myEditor.clear();
        myEditor.apply();

        startActivity(new Intent(this, IniciarSesionActivity.class));
        finish();
    }

    public void clickAgregarProducto (View view){
       startActivity(new Intent(this, FormularioActivity1.class));
    }
}