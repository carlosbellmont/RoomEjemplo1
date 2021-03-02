package com.cbellmont.livedataejemplo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {

    val pokemonList : MutableLiveData<List<Pokemon>> by lazy { MutableLiveData<List<Pokemon>>() }

    var pokemonList2 : LiveData<List<Pokemon>>

    init {
        pokemonList2 = App.db.pokemonDao().getAllLive()
    }
    /*suspend fun insertPokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            App.db.pokemonDao().insert(pokemon)
        }
    }

    suspend fun getPokemonDeDb() : Pokemon{
        return withContext(Dispatchers.IO){
            App.db.pokemonDao().getAll()[0]
        }
    }*/


    suspend fun insertPokemon(pokemon: Pokemon) {
        viewModelScope.async(Dispatchers.IO) {
            App.db.pokemonDao().insert(pokemon)
        }.await()
    }

    suspend fun getPokemonDeDb() : Pokemon{
        return viewModelScope.async(Dispatchers.IO) {
            App.db.pokemonDao().getAll()[0]
        }.await()

    }


    ///////////////////////////// Método 1

    fun insertPokemonContinuo(){
        viewModelScope.launch(Dispatchers.IO) {
            var i = 0
            do {
                insertPokemon()
                delay(5000)
                //updatePokemonList()
                i++
            } while (i < 100)
        }
    }

    fun insertPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val num = Random.nextInt()
            App.db.pokemonDao().insert(Pokemon("Pokemon$num", "Tipo$num", num))
        }
    }

    fun updatePokemonList() {
        viewModelScope.launch {
            var list : List<Pokemon>
            withContext(Dispatchers.IO) {
                list = App.db.pokemonDao().getAll()
            }
            withContext(Dispatchers.Main){
                pokemonList.value = list
            }
        }
    }



}