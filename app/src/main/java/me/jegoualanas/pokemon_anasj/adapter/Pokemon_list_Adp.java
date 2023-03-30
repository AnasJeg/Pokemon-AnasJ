package me.jegoualanas.pokemon_anasj.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.jegoualanas.pokemon_anasj.R;
import me.jegoualanas.pokemon_anasj.comm.Comm;
import me.jegoualanas.pokemon_anasj.inter.ItemService;
import me.jegoualanas.pokemon_anasj.models.Pokemon;

public class Pokemon_list_Adp extends RecyclerView.Adapter<Pokemon_list_Adp.MyView> {

    Context context;
    List<Pokemon> pokemonList;



    public Pokemon_list_Adp(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.pokemon_list_item,parent,false);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        Glide.with(context).load(pokemonList.get(position).getImg()).into(holder.pkimg);
        holder.pktxt.setText(pokemonList.get(position).getName());

        holder.setItemService(new ItemService() {
            @Override
            public void onClick(View view, int position) {
              //  Toast.makeText(context, "pok sm :"+pokemonList.get(position).getName(), Toast.LENGTH_LONG).show();

                LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(new Intent(Comm.ENABLE_KEY_HOME).putExtra("position", position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class MyView extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView pkimg;
        TextView pktxt;
        ItemService itemService;

        public void setItemService(ItemService itemService) {
            this.itemService = itemService;
        }
        public MyView(@NonNull View itemView) {
            super(itemView);
            pkimg=itemView.findViewById(R.id.pokemonImg);
            pktxt=itemView.findViewById(R.id.pok_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemService.onClick(view,getAdapterPosition());
        }
    }
}
