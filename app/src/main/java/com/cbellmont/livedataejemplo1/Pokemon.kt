package com.cbellmont.livedataejemplo1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(var nombre : String, var tipo : String, var nivel : Int) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

}