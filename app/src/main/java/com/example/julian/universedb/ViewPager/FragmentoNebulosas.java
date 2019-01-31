package com.example.julian.universedb.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julian.universedb.AnimationUtils;
import com.example.julian.universedb.R;
import com.example.julian.universedb.mydb.activity.MyDbActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoSupernovas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoSupernovas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoNebulosas extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentoNebulosas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoSupernovas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoSupernovas newInstance(String param1, String param2) {
        FragmentoSupernovas fragment = new FragmentoSupernovas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentonebulosas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //***Aca Tengo Asignados Los 6 ImageButton de los equipos cargados hasta el momento***


        TextView tvnebulosas = view.findViewById(R.id.tvnebulosas);
        TextView tvnebulosasplanetarias = view.findViewById(R.id.tvnebulosasplanetarias);

        ImageView nebulosas = view.findViewById(R.id.nebulosas);
        ImageView nebulosasplanetarias = view.findViewById(R.id.nebulosasplanetarias);


        AnimationUtils.enterLeft(tvnebulosas, 2000);
        AnimationUtils.enterRight(tvnebulosasplanetarias, 2500);


        AnimationUtils.enterRight(nebulosas, 1000);

        AnimationUtils.enterLeft(nebulosasplanetarias, 1500);

        nebulosas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MyDbActivity.class);
                startActivity(i);
            }

        });

        nebulosasplanetarias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MyDbActivity.class);
                startActivity(i);
            }
        });
    }
    //***Aca Termina El onViewCreated (Para declarar algun objeto, hacerlo aca)***


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
