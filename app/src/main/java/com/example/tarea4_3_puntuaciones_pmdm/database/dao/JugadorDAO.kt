package com.example.tarea4_3_puntuaciones_pmdm.database.dao

import androidx.room.*
import com.example.tarea4_3_puntuaciones_pmdm.database.entidades.JugadorEntity

@Dao
interface JugadorDAO {
    @Query("SELECT * FROM jugador_Entity")
    suspend fun getTodosJugadores(): MutableList<JugadorEntity>       // Función que devuelve todos los jugadores en una lista Mutable.

    @Insert
    suspend fun addJugador(jugadorEntity: JugadorEntity):Long   // Función que añade un jugador pasado por parámetro y devuelve el id insertado.

    @Query("SELECT * FROM jugador_Entity where id like :id")
    suspend fun getJugadorPorId(id: Long): JugadorEntity            // Función que busca jugadores por su id

    @Update
    suspend fun updateJugador(jugadorEntity: JugadorEntity):Int // Función que actualiza un jugador y devuelve el id actualizado

    @Delete
    suspend fun deleteJugador(jugadorEntity: JugadorEntity):Int // Función que borra un jugador y devuelve el id borrado

}