package me.jegoualanas.pokemon_anasj.comm;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import me.jegoualanas.pokemon_anasj.models.Pokemon;

public class Comm {
    public static List<Pokemon> comlist=new ArrayList<>();
    public static final String KEY_POKEMON_TYPE = "type";
    public final static String ENABLE_KEY_HOME = "position";
    public static final String KEY_NUM_EVOLUTION = "num";

    public static Pokemon findPokemonByNum(String num) {
        for(Pokemon pokemon : comlist)
        {
            if(pokemon.getNum().equals(num))
                return pokemon;
        }
        return null;
    }

    public static int getColorByType(String s) {
        switch(s)
        {

            case "Normal":
                return Color.parseColor("#A4A27A");


            case "Dragon":
                return Color.parseColor("#743BFB");



            case "Psychic":
                return Color.parseColor("#F15B85");


            case "Electric":
                return Color.parseColor("#E9CA3C");


            case "Ground":
                return Color.parseColor("#D9BF6C");


            case "Grass":
                return Color.parseColor("#81C85B");

            case "Poison":
                return Color.parseColor("#A441A3");

            case "Steel":
                return Color.parseColor("#BAB7D2");


            case "Fairy":
                return Color.parseColor("#DDA2DF");


            case "Fire":
                return Color.parseColor("#F48130");


            case "Fight":
                return Color.parseColor("#BE3027");


            case "Bug":
                return Color.parseColor("#A8B822");


            case "Ghost":
                return Color.parseColor("#705693");


            case "Dark":
                return Color.parseColor("#745945");


            case "Ice":
                return Color.parseColor("#9BD8D8");


            case "Water":
                return Color.parseColor("#658FF1");
            default:
                return Color.parseColor("#658FA0");
        }
    }

   /* public static List<Pokemon> findPokemonsByType(String type) {
        List<Pokemon> result = new ArrayList<>();
        for(Pokemon pokemon : comlist)
        {
            if(pokemon.getType().contains(type))
                result.add(pokemon);
        }
        return result;
    }
    */
}
