package com.example.mantilla_portilla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> ListaPrincipalProductos;
    private RecyclerView rvListadoProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.listado));
        cargarDatos();

        rvListadoProductos = findViewById(R.id.rv_listado_productos);

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
                ListaPrincipalProductos.remove(posicion);
                miAdaptador.setListadoInformacion(ListaPrincipalProductos);

            }
        });

        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void cargarDatos(){
        Producto producto1 = new Producto("Computador HP", 8000000.0, "https://img2.freepng.es/20180928/jvx/kisspng-hewlett-packard-hp-envy-laptop-2-in-1-pc-hp-spectr-refurbished-printers-refurbished-monitors-and-lc-5bae06a16044e3.4851795315381316173943.jpg");

        Producto producto2 = new Producto("teclado DELL", 250000.0, "https://img2.freepng.es/20180602/opx/kisspng-computer-keyboard-dell-optiplex-laptop-computer-mo-5b12386f8e5704.567606171527920751583.jpg" );
        Producto producto3 = new Producto("Mouse", 50000.0, "https://ibitsphil.com/wp-content/uploads/2017/11/Dell-WM126-Wireless-Optical-Mouse.png");
        ListaPrincipalProductos = new ArrayList<>() ;

        ListaPrincipalProductos.add(producto1);
        ListaPrincipalProductos.add(producto2);
        ListaPrincipalProductos.add(producto3);
    }
}