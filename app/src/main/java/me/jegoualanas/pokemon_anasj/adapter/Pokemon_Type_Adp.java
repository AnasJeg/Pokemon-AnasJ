package me.jegoualanas.pokemon_anasj.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.jegoualanas.pokemon_anasj.R;
import me.jegoualanas.pokemon_anasj.comm.Comm;

public class Pokemon_Type_Adp extends RecyclerView.Adapter<Pokemon_Type_Adp.MyView> {


    Context context;
    List<String> typeList;

    public Pokemon_Type_Adp(Context context, List<String> typeList) {
        context = context;
        this.typeList = typeList;
    }
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_type, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.pok_type.setText(typeList.get(position));
        holder.pok_type.setBackgroundColor(Comm.getColorByType(typeList.get(position)));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyView extends RecyclerView.ViewHolder{
        TextView pok_type;
        public MyView(@NonNull View itemView) {
            super(itemView);
            pok_type = itemView.findViewById(R.id.pok_type);
            pok_type.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LocalBroadcastManager.getInstance(context)
                            .sendBroadcast(new Intent(Comm.KEY_POKEMON_TYPE).putExtra("type", typeList.get(getAdapterPosition())));
                }
            });
        }
    }
}
