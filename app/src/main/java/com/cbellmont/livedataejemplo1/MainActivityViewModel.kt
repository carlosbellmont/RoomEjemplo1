package com.cbellmont.livedataejemplo1

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {


    fun getPokemonDeDb() : Pokemon{
       return App.db.pokemonDao().getAll()[0]
    }
}