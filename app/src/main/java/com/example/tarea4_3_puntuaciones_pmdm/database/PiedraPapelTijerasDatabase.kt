package com.example.tarea4_3_puntuaciones_pmdm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tarea4_3_puntuaciones_pmdm.database.dao.JugadorDAO
import com.example.tarea4_3_puntuaciones_pmdm.database.entidades.JugadorEntity


@Database(entities = [JugadorEntity::class, PartidaEntity::class], version = 1)
abstract class PiedraPapelTijerasDatabase : RoomDatabase() {
    abstract fun jugadorDao(): JugadorDAO
    abstract  fun partidaDao(): PartidaDAO
}