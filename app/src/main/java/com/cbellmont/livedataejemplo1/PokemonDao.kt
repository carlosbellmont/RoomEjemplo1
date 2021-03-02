package com.cbellmont.livedataejemplo1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PokemonDao {
    @Query("SELECT * FROM Pokemon")
    fun getAll(): List<Pokemon>
    @Query("SELECT * FROM Pokemon")
    fun getAllLive(): LiveData<List<Pokemon>>
    @Insert
    fun insert(pokemon: Pokemon)
    @Insert
    fun insertAll(pokemonList: List<Pokemon>)
    @Update
    fun update(pokemon: Pokemon)
    @Delete
    fun delete(pokemon: Pokemon)
    @Delete
    fun deleteAll(pokemonList: List<Pokemon>)
}
