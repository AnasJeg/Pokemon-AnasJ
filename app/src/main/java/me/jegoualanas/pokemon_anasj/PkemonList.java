package me.jegoualanas.pokemon_anasj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import me.jegoualanas.pokemon_anasj.adapter.Pokemon_list_Adp;
import me.jegoualanas.pokemon_anasj.comm.Comm;
import me.jegoualanas.pokemon_anasj.comm.ItemDec;
import me.jegoualanas.pokemon_anasj.models.Pokedex;
import me.jegoualanas.pokemon_anasj.retrofit.IPokemondex;
import me.jegoualanas.pokemon_anasj.retrofit.RetrofitClient;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PkemonList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PkemonList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    IPokemondex iPokemondex;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    RecyclerView recyclerViewPK_list;
    static PkemonList instance;

    public static PkemonList getInstance() {
        if(instance==null){
            instance = new PkemonList();
        }
        return instance;
    }

    public PkemonList() {
        Retrofit retrofit= RetrofitClient.getInstance();
        iPokemondex=retrofit.create(IPokemondex.class);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PkemonList.
     */
    // TODO: Rename and change types and number of parameters
    public static PkemonList newInstance(String param1, String param2) {
        PkemonList fragment = new PkemonList();
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
         View view = inflater.inflate(R.layout.fragment_pkemon_list, container, false);
         recyclerViewPK_list = view.findViewById(R.id.pok_list_rec);
         recyclerViewPK_list.setHasFixedSize(true);
         recyclerViewPK_list.setLayoutManager(new GridLayoutManager(getActivity(),2));
        ItemDec itemDec=new ItemDec(getActivity(),R.dimen.test);
        recyclerViewPK_list.addItemDecoration(itemDec);

        getAllData();
        return view;
    }

    private void getAllData() {

    compositeDisposable.add(iPokemondex.getListPokemon()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Pokedex>() {
                @Override
                public void accept(Pokedex pokedex) throws Throwable {
                    Comm.comlist=pokedex.getPokemon();
                    Pokemon_list_Adp pokemon_list_adp=new Pokemon_list_Adp(getActivity(),Comm.comlist);
                    recyclerViewPK_list.setAdapter(pokemon_list_adp);
                }
            })
    );

    }
}