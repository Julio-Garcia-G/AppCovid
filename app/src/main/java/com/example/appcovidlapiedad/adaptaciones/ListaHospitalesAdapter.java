package com.example.appcovidlapiedad.adaptaciones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appcovidlapiedad.R;
import com.example.appcovidlapiedad.tablas.Ocupacion_hospitales;

import java.util.ArrayList;

public class ListaHospitalesAdapter extends RecyclerView.Adapter<ListaHospitalesAdapter.HospitalesViewHolder>
        implements View.OnClickListener {

    ArrayList<Ocupacion_hospitales> listaHospital;
    private View.OnClickListener listener;

    public ListaHospitalesAdapter(ArrayList<Ocupacion_hospitales> listaHospital) {
        this.listaHospital = listaHospital;
    }

    @Override
    public HospitalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hospitales,null,false);

        view.setOnClickListener(this);

        return new HospitalesViewHolder(view);
    }

    //Se coloca el nombre en el TextView y el porcentaje de ocupación en el TextView y la ProgressBar
    @Override
    public void onBindViewHolder(HospitalesViewHolder holder, int position) {
        holder.nombre.setText(listaHospital.get(position).getNombre());
        holder.porcentaje_ocupacion.setText(listaHospital.get(position).getPorcentaje_ocupacion().toString()+"%");
        holder.porcentaje.setProgress(Integer.parseInt(listaHospital.get(position).getPorcentaje_ocupacion().toString()));
    }

    @Override
    public int getItemCount() {
        return listaHospital.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public class HospitalesViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,porcentaje_ocupacion;
        ProgressBar porcentaje;

        public HospitalesViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            porcentaje_ocupacion = (TextView) itemView.findViewById(R.id.textPorcentaje);
            porcentaje = (ProgressBar) itemView.findViewById(R.id.porcentajeOcup);
        }
    }
}
