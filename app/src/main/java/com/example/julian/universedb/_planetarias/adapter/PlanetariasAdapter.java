package com.example.julian.universedb._planetarias.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julian.universedb.R;
import com.example.julian.universedb.db.entities.Planetarias;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class PlanetariasAdapter extends RecyclerView.Adapter<PlanetariasAdapter.PlanetariasViewHolder> {

    private Context context;
    private PlanetariasAdapter.OnViewHolderClick clickListener;

    private List<Planetarias> planetarias;

    public PlanetariasAdapter(Context context, PlanetariasAdapter.OnViewHolderClick clickListener, List<Planetarias> planetarias) {
        this.context = context;
        this.clickListener = clickListener;
        this.planetarias = planetarias;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetariasAdapter.PlanetariasViewHolder holder, int position) {
        bindView(getItem(position), holder);
    }

    private void bindView(Planetarias planetarias, PlanetariasAdapter.PlanetariasViewHolder viewHolder) {
        if (planetarias != null) {
            setUpPlanetarias(planetarias, viewHolder);
        }
    }

    private void setUpPlanetarias(Planetarias planetarias, PlanetariasAdapter.PlanetariasViewHolder viewHolder) {
        // para setear varios valores con String.format
        /*viewHolder.observacion.setText(String.format(Locale.getDefault(), "uid: %d cell: %s email: %s gender: %s nat: %s",
                User.uid,
                User.cell,
                User.email,
                User.gender,
                User.nat));*/

        // seteando strings
        viewHolder.name.setText(planetarias.name);
        viewHolder.tipo.setText(planetarias.tipo);
        viewHolder.distancia.setText(planetarias.distancia);
        viewHolder.descripcion.setText(planetarias.descripcion);
        viewHolder.constelacion.setText(planetarias.constelacion);
        viewHolder.declinaciN.setText(planetarias.declinaciN);
        viewHolder.ascensiNrecta.setText(planetarias.ascensiNrecta);
        viewHolder.otrasDesignaciones.setText(planetarias.otrasDesignaciones);

        // para mostrar imagenes con Picasso
        //Picasso.get().load(User.picture.thumbnail).into(viewHolder.thumbnail);
        Picasso.get().load(planetarias.image).into(viewHolder.imageView);
        Picasso.get()
                .load(planetarias.image)
                .resize(100, 100)
                .centerCrop()
                .into(viewHolder.imageView);


    }

    @NonNull
    @Override
    public PlanetariasAdapter.PlanetariasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlanetariasAdapter.PlanetariasViewHolder(createView(context, parent, viewType), clickListener);
    }

    private View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.planetarias_list, viewGroup, false);
    }

    @Override
    public int getItemCount() {
        return planetarias == null ? 0 : planetarias.size();
    }

    public void addAll(List<Planetarias> list) {
        planetarias.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        planetarias.clear();
        notifyDataSetChanged();
    }

    private Planetarias getItem(int index) {
        return ((planetarias != null && index < planetarias.size()) ? planetarias.get(index) : null);
    }

    public List<Planetarias> getList() {
        return planetarias;
    }

    public interface OnViewHolderClick {
        void onClick(View view, int position, Planetarias item);
    }

    public class PlanetariasViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.nameplanetarias)
        TextView name;

        @BindView(R.id.tipoplanetarias)
        TextView tipo;

        @BindView(R.id.distanciaplanetarias)
        TextView distancia;

        @BindView(R.id.descripcionplanetarias)
        TextView descripcion;

        @BindView(R.id.constelacionplanetarias)
        TextView constelacion;

        @BindView(R.id.ascensiNrectaplanetarias)
        TextView ascensiNrecta;

        @BindView(R.id.declinaciNplanetarias)
        TextView declinaciN;

        @BindView(R.id.otrasDesignacionesplanetarias)
        TextView otrasDesignaciones;

        @BindView(R.id.imageplanetarias)
        ImageView imageView;

        PlanetariasViewHolder(View view, PlanetariasAdapter.OnViewHolderClick listener) {
            super(view);
            ButterKnife.bind(this, view);

            if (listener != null)
                view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onClick(view, getAdapterPosition(), getItem(getAdapterPosition()));
        }
    }
}
