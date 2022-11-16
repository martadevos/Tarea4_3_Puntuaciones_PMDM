package com.example.tarea4_3_puntuaciones_pmdm.database.dao

import androidx.room.*
import com.example.tarea4_3_puntuaciones_pmdm.database.entidades.JugadorEntity
import com.example.tarea4_3_puntuaciones_pmdm.database.entidades.PartidaEntity

@Dao
interface PartidaDAO {
    // Función que devuelve una lista mutable con todas las partidas jugadas.
    @Query("SELECT * FROM partida_entity")
    suspend fun getAllTasks(): MutableList<PartidaEntity>

    // Función que devuelve una devuelve una lista mutable de las partidas de un jugador por su id
    @Query("SELECT * FROM partida_entity where id_jugador like :idJugador")
    suspend fun getPartidasPorIdJugador(idJugador: Long): MutableList<PartidaEntity>

    @Query("SELECT COUNT(*) FROM partida_entity WHERE id_jugador LIKE :idJugador")
    suspend fun getTotalPartidasJugadas(idJugador: Long): Int

    // Función que busca la mejor partida de un jugador con el id de este
    @Query("SELECT * FROM partida_entity where id_jugador like :idJugador ORDER BY (puntuacion_jugador - puntuacion_maquina) DESC LIMIT 1")
    suspend fun getMejorPartidaPorIdJugador(idJugador: Long): MutableList<PartidaEntity>

    // Función que añade un jugador pasado por parámetro y devuelve el id insertado.
    @Insert
    suspend fun addJugador(partidaEntity: PartidaEntity): Long

    // Función que actualiza una partida y devuelve el id actualizado
    @Update
    suspend fun updateJugador(partidaEntity: PartidaEntity): Int

    // Función que borra una partida y devuelve el id borrado
    @Delete
    suspend fun deleteJugador(partidaEntity: PartidaEntity): Int

}