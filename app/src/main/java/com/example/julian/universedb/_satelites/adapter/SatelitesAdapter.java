package com.example.julian.universedb._satelites.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julian.universedb.R;
import com.example.julian.universedb.db.entities.Satelites;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class SatelitesAdapter extends RecyclerView.Adapter<SatelitesAdapter.SatelitesViewHolder> {

    private Context context;
    private SatelitesAdapter.OnViewHolderClick clickListener;

    private List<Satelites> mSatelites;

    public SatelitesAdapter(Context context, SatelitesAdapter.OnViewHolderClick clickListener, List<Satelites> mSatelites) {
        this.context = context;
        this.clickListener = clickListener;
        this.mSatelites = mSatelites;
    }

    @Override
    public void onBindViewHolder(@NonNull SatelitesViewHolder holder, int position) {
        bindView(getItem(position), holder);
    }

    private void bindView(Satelites satelites, SatelitesViewHolder viewHolder) {
        if (satelites != null) {
            setUpSatelites(satelites, viewHolder);
        }
    }

    private void setUpSatelites(Satelites satelites, SatelitesViewHolder viewHolder) {
        // para setear varios valores con String.format
        /*viewHolder.observacion.setText(String.format(Locale.getDefault(), "uid: %d cell: %s email: %s gender: %s nat: %s",
                User.uid,
                User.cell,
                User.email,
                User.gender,
                User.nat));*/

        // seteando strings
        viewHolder.nombre.setText(satelites.nombre);
        viewHolder.tipo.setText(satelites.tipo);
        viewHolder.planeta.setText(satelites.planeta);
        viewHolder.caracteristicas.setText(satelites.caracteristicas);
        viewHolder.descubridor.setText(satelites.descubridor);


        // para mostrar imagenes con Picasso
        //Picasso.get().load(User.picture.thumbnail).into(viewHolder.thumbnail);
        Picasso.get().load(satelites.image).into(viewHolder.imageView);
        Picasso.get()
                .load(satelites.image)
                .resize(100, 100)
                .centerCrop()
                .into(viewHolder.imageView);
    }

    @NonNull
    @Override
    public SatelitesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SatelitesViewHolder(createView(context, parent, viewType), clickListener);
    }

    private View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.satelites_list, viewGroup, false);
    }

    @Override
    public int getItemCount() {
        return mSatelites == null ? 0 : mSatelites.size();
    }

    public void addAll(List<Satelites> list) {
        mSatelites.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        mSatelites.clear();
        notifyDataSetChanged();
    }

    private Satelites getItem(int index) {
        return ((mSatelites != null && index < mSatelites.size()) ? mSatelites.get(index) : null);
    }

    public List<Satelites> getList() {
        return mSatelites;
    }

    public interface OnViewHolderClick {
        void onClick(View view, int position, Satelites item);
    }

    public class SatelitesViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.tvnombre)
        TextView nombre;

        @BindView(R.id.tvtipo)
        TextView tipo;


        @BindView(R.id.tvplaneta)
        TextView planeta;

        @BindView(R.id.tvcaracteristicas)
        TextView caracteristicas;

        @BindView(R.id.tvdescubridor)
        TextView descubridor;


        @BindView(R.id.imageSatelites)
        ImageView imageView;

        SatelitesViewHolder(View view, SatelitesAdapter.OnViewHolderClick listener) {
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