package me.jegoualanas.pokemon_anasj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import me.jegoualanas.pokemon_anasj.comm.Comm;
import me.jegoualanas.pokemon_anasj.fragment.DetailFragment;
import me.jegoualanas.pokemon_anasj.fragment.PokemonList;
import me.jegoualanas.pokemon_anasj.models.Pokemon;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    BroadcastReceiver showDetail = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().toString().equals(Comm.ENABLE_KEY_HOME)){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Enable back button on toolBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true); //too

                //Remplace FRAGMENT
                Fragment detailFragment = DetailFragment.getInstance();
                int position = intent.getIntExtra("position", -1);
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                detailFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, detailFragment);
                fragmentTransaction.addToBackStack("detail");
                fragmentTransaction.commit();

                //name -> toolbar
                Pokemon pokemon = Comm.comlist.get(position);
                toolbar.setTitle(pokemon.getName());

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("AJ-POK");
        setSupportActionBar(toolbar);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(showDetail, new IntentFilter(Comm.ENABLE_KEY_HOME));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                toolbar.setTitle("AJ-POK");

                getSupportFragmentManager().popBackStack("detail", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                getSupportFragmentManager().popBackStack("type", FragmentManager.POP_BACK_STACK_INCLUSIVE);

                Fragment pokemonList = PokemonList.getInstance();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.remove(pokemonList);
                fragmentTransaction.replace(R.id.fragmentContainerView, pokemonList);
                fragmentTransaction.commit();

                getSupportActionBar().setDisplayShowHomeEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);


                break;
            default:
                break;

        }
        return true;
    }
}