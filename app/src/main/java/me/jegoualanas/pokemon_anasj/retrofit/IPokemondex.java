package me.jegoualanas.pokemon_anasj.retrofit;


import io.reactivex.rxjava3.core.Observable;
import me.jegoualanas.pokemon_anasj.models.Pokedex;
import retrofit2.http.GET;

public interface IPokemondex {
    @GET("pokedex.json")
    Observable<Pokedex> getListPokemon();

}
