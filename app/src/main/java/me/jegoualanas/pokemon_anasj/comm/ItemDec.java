package me.jegoualanas.pokemon_anasj.comm;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDec extends RecyclerView.ItemDecoration {

    private int it;

    public ItemDec(int it) {
        this.it = it;
    }

    public  ItemDec(@Nullable Context context, @DimenRes int dim){
        this(context.getResources().getDimensionPixelSize(dim));

    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(it,it,it,it);
    }
}
