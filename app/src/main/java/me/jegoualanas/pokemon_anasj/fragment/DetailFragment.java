package me.jegoualanas.pokemon_anasj.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import me.jegoualanas.pokemon_anasj.R;
import me.jegoualanas.pokemon_anasj.adapter.Pokemon_Type_Adp;
import me.jegoualanas.pokemon_anasj.comm.Comm;
import me.jegoualanas.pokemon_anasj.models.Pokemon;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView pok_img;
    TextView pokname,pokheight,pokweight;
    RecyclerView recycler_type;
    static DetailFragment instance;

    public static DetailFragment getInstance() {
        if(instance == null)
            instance = new DetailFragment();
        return instance;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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
        View itemView = inflater.inflate(R.layout.fragment_detail, container, false);

      //  Pokemon pokemon = Comm.findPokemonByNum(getArguments().getString("num"));
        Pokemon pokemon = Comm.comlist.get(getArguments().getInt("position"));

        pok_img = (ImageView)itemView.findViewById(R.id.pokimg);
        pokname = (TextView) itemView.findViewById(R.id.pokName);
        pokheight= (TextView) itemView.findViewById(R.id.height);
        pokweight = (TextView) itemView.findViewById(R.id.weight);

        recycler_type = (RecyclerView)itemView.findViewById(R.id.typeList);
        recycler_type.setHasFixedSize(true);
        recycler_type.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        
        setDetailPok(pokemon);

        return itemView;
    }

    private void setDetailPok(Pokemon pokemon) {
        //Load Image
        Glide.with(getActivity()).load(pokemon.getImg()).into(pok_img);

        pokname.setText(pokemon.getName());
        pokheight.setText(pokemon.getHeight());
        pokweight.setText(pokemon.getWeight());

        //Set Type
        Pokemon_Type_Adp typeAdapter = new Pokemon_Type_Adp(getActivity(), pokemon.getType());
        recycler_type.setAdapter(typeAdapter);

    }
}