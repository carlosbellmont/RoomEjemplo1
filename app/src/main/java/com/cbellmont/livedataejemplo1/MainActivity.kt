package com.cbellmont.livedataejemplo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.cbellmont.livedataejemplo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = ViewModelProvider(this).get(MainActivityViewModel::class.java)



        //// METODO 1
        /*
        model.pokemonList.observe(this){ list ->
            var text = ""
            list.forEach {
                text += it.nombre
            }
            binding.tvValue.text = text
        }

        model.insertPokemonContinuo()*/

        /////////// METODO 2



        model.pokemonList2.observe(this){ list ->
            var text = ""
            list.forEach {
                text += it.nombre
            }
            binding.tvValue.text = text
        }

        model.insertPokemonContinuo()

        /*lifecycleScope.launch {
            model.insertPokemon( Pokemon("Pokemon1", "tipo a", 99))
            val pokemon = model.getPokemonDeDb()
            binding.tvValue.text = pokemon.nombre
        }*/




        //var pokemon = model.getPokemonDeDb()
        /* Ejemplo de como leer desde ActivityMain a la base de datos. Pero NO ES RECOMENDABLE.
        lifecycleScope.launch(Dispatchers.IO) {
            var pokemonList = App.db.pokemonDao().getAll()
            val p = Pokemon("Pokemon1", "tipo a", 99)
            withContext(Dispatchers.Main) {
                binding.tvValue.text = p.nombre
            }
        }*/


    }
}