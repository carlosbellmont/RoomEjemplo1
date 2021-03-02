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