package com.example.julian.universedb.mydb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julian.universedb.R;
import com.example.julian.universedb.db.entities.Users;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Santiago Battaglino.
 */
public class MyDbAdapter extends RecyclerView.Adapter<MyDbAdapter.UserViewHolder> {

    private Context context;
    private MyDbAdapter.OnViewHolderClick clickListener;

    private List<Users> usuarios;

    public MyDbAdapter(Context context, MyDbAdapter.OnViewHolderClick clickListener, List<Users> usuarios) {
        this.context = context;
        this.clickListener = clickListener;
        this.usuarios = usuarios;
    }

    @Override
    public void onBindViewHolder(@NonNull MyDbAdapter.UserViewHolder holder, int position) {
        bindView(getItem(position), holder);
    }

    private void bindView(Users users, MyDbAdapter.UserViewHolder viewHolder) {
        if (users != null) {
            setUpUser(users, viewHolder);
        }
    }

    private void setUpUser(Users user, MyDbAdapter.UserViewHolder viewHolder) {
        // para setear varios valores con String.format
        /*viewHolder.observacion.setText(String.format(Locale.getDefault(), "uid: %d cell: %s email: %s gender: %s nat: %s",
                User.uid,
                User.cell,
                User.email,
                User.gender,
                User.nat));*/

        // para mostrar imagenes con Picasso
        //Picasso.get().load(User.picture.thumbnail).into(viewHolder.thumbnail);

        // seteando strings
        viewHolder.firstname.setText(user.firstName);
        viewHolder.lastname.setText(user.lastName);
        viewHolder.nationality.setText(user.nationality);
        viewHolder.state.setText(user.state);
        viewHolder.city.setText(user.city);
        viewHolder.telephone.setText(user.telephone);
        viewHolder.email.setText(user.email);

        Picasso.get().load(user.pictureUrl).into(viewHolder.imageView);
        Picasso.get()
                .load(user.pictureUrl)
                .resize(100, 100)
                .centerCrop()
                .into(viewHolder.imageView);


    }

    @NonNull
    @Override
    public MyDbAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyDbAdapter.UserViewHolder(createView(context, parent, viewType), clickListener);
    }

    private View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.db_list, viewGroup, false);
    }

    @Override
    public int getItemCount() {
        return usuarios == null ? 0 : usuarios.size();
    }

    public void addAll(List<Users> list) {
        usuarios.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        usuarios.clear();
        notifyDataSetChanged();
    }

    private Users getItem(int index) {
        return ((usuarios != null && index < usuarios.size()) ? usuarios.get(index) : null);
    }

    public List<Users> getList() {
        return usuarios;
    }

    public interface OnViewHolderClick {
        void onClick(View view, int position, Users item);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.firstname)
        TextView firstname;

        @BindView(R.id.lastname)
        TextView lastname;

        @BindView(R.id.nationality)
        TextView nationality;

        @BindView(R.id.state)
        TextView state;

        @BindView(R.id.city)
        TextView city;

        @BindView(R.id.telephone)
        TextView telephone;

        @BindView(R.id.email)
        TextView email;

        @BindView(R.id.imageview)
        ImageView imageView;

        UserViewHolder(View view, MyDbAdapter.OnViewHolderClick listener) {
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
