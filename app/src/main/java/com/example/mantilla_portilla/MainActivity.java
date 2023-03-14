package com.example.mantilla_portilla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> ListaPrincipalProductos;
    private RecyclerView rvListadoProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();

        rvListadoProductos = findViewById(R.id.rv_listado_productos);

        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(ListaPrincipalProductos);

        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void cargarDatos(){
        Producto producto1 = new Producto("Computador HP", 8000000.0, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcompucentro.co%2Fcomputador-todo-en-uno-hp-dd1506la-21-5-pulgadas-intel-core-i3-ram-8gb-disco-ssd-256-gb-negro%2F&psig=AOvVaw11tkZk5Dt9MHnhZgIL_6_6&ust=1678917082856000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCNiM0NWz3P0CFQAAAAAdAAAAABAE");

        Producto producto2 = new Producto("teclado DELL", 250000.0, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pngwing.com%2Fes%2Ffree-png-cnfmv&psig=AOvVaw0t6AMNQelNXmBq2TEJq5_w&ust=1678917403241000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCLiwvO203P0CFQAAAAAdAAAAABAE" );
        Producto producto3 = new Producto("Mouse", 50000.0, "https://www.google.com/imgres?imgurl=https%3A%2F%2Fe7.pngegg.com%2Fpngimages%2F872%2F96%2Fpng-clipart-computer-mouse-logitech-g203-prodigy-optical-mouse-computer-keyboard-amazon-usb-headset.png&imgrefurl=https%3A%2F%2Fwww.pngegg.com%2Fes%2Fpng-wxjhz&tbnid=M_2pMDFv0UJ74M&vet=12ahUKEwiM356Ftdz9AhXGlYQIHQfBAFMQMygGegUIARDIAQ..i&docid=793NxXLtuZfoYM&w=900&h=759&q=mouse%20png&ved=2ahUKEwiM356Ftdz9AhXGlYQIHQfBAFMQMygGegUIARDIAQ");
        ListaPrincipalProductos = new ArrayList<>() ;

        ListaPrincipalProductos.add(producto1);
        ListaPrincipalProductos.add(producto2);
        ListaPrincipalProductos.add(producto3);
    }
}