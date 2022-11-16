package com.example.tarea4_3_puntuaciones_pmdm

import android.app.Application
import androidx.room.Room
import com.example.tarea4_3_puntuaciones_pmdm.database.PiedraPapelTijerasDatabase

class PiedraPapelTijerasApp: Application() {
    companion object {
        lateinit var database: PiedraPapelTijerasDatabase
    }
    override fun onCreate() {
        super.onCreate()
        PiedraPapelTijerasApp.database =  Room.databaseBuilder(this, PiedraPapelTijerasDatabase::class.java, "piedra_papel_tijeras-db").build()
    }
}