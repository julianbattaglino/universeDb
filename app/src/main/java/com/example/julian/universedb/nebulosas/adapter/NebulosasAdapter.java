package com.example.julian.universedb.nebulosas.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julian.universedb.R;
import com.example.julian.universedb.db.entities.Nebulosas;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class NebulosasAdapter extends RecyclerView.Adapter<NebulosasAdapter.NebulosasViewHolder> {

    private Context context;
    private NebulosasAdapter.OnViewHolderClick clickListener;

    private List<Nebulosas> nebulosas;

    public NebulosasAdapter(Context context, NebulosasAdapter.OnViewHolderClick clickListener, List<Nebulosas> nebulosas) {
        this.context = context;
        this.clickListener = clickListener;
        this.nebulosas = nebulosas;
    }

    @Override
    public void onBindViewHolder(@NonNull NebulosasAdapter.NebulosasViewHolder holder, int position) {
        bindView(getItem(position), holder);
    }

    private void bindView(Nebulosas nebulosas, NebulosasAdapter.NebulosasViewHolder viewHolder) {
        if (nebulosas != null) {
            setUpNebulosas(nebulosas, viewHolder);
        }
    }

    private void setUpNebulosas(Nebulosas nebulosas, NebulosasAdapter.NebulosasViewHolder viewHolder) {
        // para setear varios valores con String.format
        /*viewHolder.observacion.setText(String.format(Locale.getDefault(), "uid: %d cell: %s ascensiNrecta: %s gender: %s nat: %s",
                User.uid,
                User.cell,
                User.ascensiNrecta,
                User.gender,
                User.nat));*/

        // para mostrar imagenes con Picasso
        //Picasso.get().load(User.picture.thumbnail).into(viewHolder.thumbnail);

        // seteando strings
        viewHolder.name.setText(nebulosas.name);
        viewHolder.tipo.setText(nebulosas.tipo);
        viewHolder.distancia.setText(nebulosas.distancia);
        viewHolder.descripcion.setText(nebulosas.descripcion);
        viewHolder.constelacion.setText(nebulosas.constelacion);
        viewHolder.ascensiNrecta.setText(nebulosas.ascensiNrecta);
        viewHolder.declinaciN.setText(nebulosas.declinaciN);
        viewHolder.ascensiNrecta.setText(nebulosas.ascensiNrecta);
        viewHolder.otrasDesignaciones.setText(nebulosas.otrasDesignaciones);


        Picasso.get().load(nebulosas.image).into(viewHolder.imageView);
        Picasso.get()
                .load(nebulosas.image)
                .resize(100, 100)
                .centerCrop()
                .into(viewHolder.imageView);


    }

    @NonNull
    @Override
    public NebulosasAdapter.NebulosasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NebulosasAdapter.NebulosasViewHolder(createView(context, parent, viewType), clickListener);
    }

    private View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.nebula_list, viewGroup, false);
    }

    @Override
    public int getItemCount() {
        return nebulosas == null ? 0 : nebulosas.size();
    }

    public void addAll(List<Nebulosas> list) {
        nebulosas.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        nebulosas.clear();
        notifyDataSetChanged();
    }

    private Nebulosas getItem(int index) {
        return ((nebulosas != null && index < nebulosas.size()) ? nebulosas.get(index) : null);
    }

    public List<Nebulosas> getList() {
        return nebulosas;
    }

    public interface OnViewHolderClick {
        void onClick(View view, int position, Nebulosas item);
    }

    public class NebulosasViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.tipo)
        TextView tipo;

        @BindView(R.id.distancia)
        TextView distancia;

        @BindView(R.id.descripcion)
        TextView descripcion;

        @BindView(R.id.constelacion)
        TextView constelacion;

        @BindView(R.id.ascensiNrecta)
        TextView ascensiNrecta;

        @BindView(R.id.declinaciN)
        TextView declinaciN;

        @BindView(R.id.otrasDesignaciones)
        TextView otrasDesignaciones;

        @BindView(R.id.imageview)
        ImageView imageView;

        NebulosasViewHolder(View view, NebulosasAdapter.OnViewHolderClick listener) {
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
