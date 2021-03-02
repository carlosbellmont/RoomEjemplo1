package com.cbellmont.livedataejemplo1

import android.app.Application
import androidx.room.Room

class App : Application() {

    companion object { lateinit var db : AppDatabase }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").build()
    }
}
