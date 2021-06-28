package com.example.appcovidlapiedad.adaptaciones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appcovidlapiedad.R;
import com.example.appcovidlapiedad.tablas.Ocupacion_hospitales;

import java.util.ArrayList;

public class ListaHospitalesAdapter extends RecyclerView.Adapter<ListaHospitalesAdapter.HospitalesViewHolder> {
    ArrayList<Ocupacion_hospitales> listaHospital;

    public ListaHospitalesAdapter(ArrayList<Ocupacion_hospitales> listaHospital) {
        this.listaHospital = listaHospital;
    }

    @Override
    public HospitalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hospitales,null,false);
        return new HospitalesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HospitalesViewHolder holder, int position) {
        holder.nombre.setText(listaHospital.get(position).getNombre());
        holder.porcentaje_ocupacion.setText(listaHospital.get(position).getPorcentaje_ocupacion().toString());
    }

    @Override
    public int getItemCount() {
        return listaHospital.size();
    }

    public class HospitalesViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,porcentaje_ocupacion;

        public HospitalesViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            porcentaje_ocupacion = (TextView) itemView.findViewById(R.id.textPorcentaje);
        }
    }
}
