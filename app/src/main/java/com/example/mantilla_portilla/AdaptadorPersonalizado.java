package com.example.mantilla_portilla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder> {

    private ArrayList<Producto> listadoInformacion;

    public AdaptadorPersonalizado(ArrayList<Producto> listadoInformacion) {
        this.listadoInformacion = listadoInformacion;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View miView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_productos,parent,false);
        return new ViewHolder(miView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {
        Producto miProducto = listadoInformacion.get(position);
        holder.enlazar(miProducto);

    }

    @Override
    public int getItemCount() {
        return listadoInformacion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombre, tvPrecio;
        private ImageView ivProducto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tv_item_nombre);
            tvPrecio = itemView.findViewById(R.id.tv_item_precio);
            ivProducto = itemView.findViewById(R.id.iv_item_imagen);
        }

        public void enlazar(Producto miProducto){
            tvNombre.setText(miProducto.getNombre());
            tvPrecio.setText(miProducto.getPrecio().toString());

        }
    }
}
