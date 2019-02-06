package com.example.julian.universedb._planetas.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julian.universedb.R;
import com.example.julian.universedb.db.entities.Planetas;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class PlanetasAdapter extends RecyclerView.Adapter<PlanetasAdapter.PlanetasViewHolder> {

    private Context context;
    private PlanetasAdapter.OnViewHolderClick clickListener;

    private List<Planetas> mPlanetas;

    public PlanetasAdapter(Context context, PlanetasAdapter.OnViewHolderClick clickListener, List<Planetas> mPlanetas) {
        this.context = context;
        this.clickListener = clickListener;
        this.mPlanetas = mPlanetas;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetasViewHolder holder, int position) {
        bindView(getItem(position), holder);
    }

    private void bindView(Planetas planetas, PlanetasViewHolder viewHolder) {
        if (planetas != null) {
            setUpPlanetas(planetas, viewHolder);
        }
    }

    private void setUpPlanetas(Planetas planetas, PlanetasViewHolder viewHolder) {
        // para setear varios valores con String.format
        /*viewHolder.observacion.setText(String.format(Locale.getDefault(), "uid: %d cell: %s email: %s gender: %s nat: %s",
                User.uid,
                User.cell,
                User.email,
                User.gender,
                User.nat));*/

        // seteando strings
        viewHolder.name.setText(planetas.name);
        viewHolder.categoria.setText(planetas.categoria);
        viewHolder.magnitudaparente.setText(planetas.magnitudAparente);
        viewHolder.elementosorbitales.setText(planetas.elementosOrbitales);
        viewHolder.elementosderivados.setText(planetas.elementosOrbitalesDerivados);
        viewHolder.atmosfera.setText(planetas.atmosfera);
        viewHolder.caracteristicasprincipales.setText(planetas.caracteristicasPrincipales);
        viewHolder.caracteristicasfisicas.setText(planetas.caracteristicasFSicas);
        viewHolder.caracteristicasatmosfericas.setText(planetas.caracteristicasAtmosfRicas);
        viewHolder.masa.setText(planetas.masa);
        viewHolder.satelites.setText(planetas.satelites);
        viewHolder.otrosdatos.setText(planetas.otrosDatos);


        // para mostrar imagenes con Picasso
        //Picasso.get().load(User.picture.thumbnail).into(viewHolder.thumbnail);
        Picasso.get().load(planetas.image).into(viewHolder.imageView);
        Picasso.get()
                .load(planetas.image)
                .resize(100, 100)
                .centerCrop()
                .into(viewHolder.imageView);
    }

    @NonNull
    @Override
    public PlanetasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlanetasViewHolder(createView(context, parent, viewType), clickListener);
    }

    private View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.planetas_list, viewGroup, false);
    }

    @Override
    public int getItemCount() {
        return mPlanetas == null ? 0 : mPlanetas.size();
    }

    public void addAll(List<Planetas> list) {
        mPlanetas.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        mPlanetas.clear();
        notifyDataSetChanged();
    }

    private Planetas getItem(int index) {
        return ((mPlanetas != null && index < mPlanetas.size()) ? mPlanetas.get(index) : null);
    }

    public List<Planetas> getList() {
        return mPlanetas;
    }

    public interface OnViewHolderClick {
        void onClick(View view, int position, Planetas item);
    }

    public class PlanetasViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.nameplanetasPlanetas)
        TextView name;

        @BindView(R.id.categoriaPlanetas)
        TextView categoria;

        @BindView(R.id.magnitudaparentePlanetas)
        TextView magnitudaparente;

        @BindView(R.id.elementosorbitalesPlanetas)
        TextView elementosorbitales;

        @BindView(R.id.elementosorbitalesderivados)
        TextView elementosderivados;

        @BindView(R.id.caracteristicasPrincipalesPlanetas)
        TextView caracteristicasprincipales;

        @BindView(R.id.atmosferaPlanetas)
        TextView atmosfera;

        @BindView(R.id.caracteristicasFisicasPlanetas)
        TextView caracteristicasfisicas;

        @BindView(R.id.caracteristicasAtmosfericasPlanetas)
        TextView caracteristicasatmosfericas;

        @BindView(R.id.masaPlanetas)
        TextView masa;

        @BindView(R.id.satelitesPlanetas)
        TextView satelites;

        @BindView(R.id.otrosDatosPlanetas)
        TextView otrosdatos;


        @BindView(R.id.imagePlanetas)
        ImageView imageView;

        PlanetasViewHolder(View view, PlanetasAdapter.OnViewHolderClick listener) {
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