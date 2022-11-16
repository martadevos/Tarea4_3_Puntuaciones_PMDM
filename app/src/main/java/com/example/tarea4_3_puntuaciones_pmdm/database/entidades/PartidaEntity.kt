package com.example.tarea4_3_puntuaciones_pmdm.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partida_entity")
data class PartidaEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0, //ID de la partida
    @ColumnInfo(name = "id_jugador") var idJugador: Long = 0, //ID del jugador
    @ColumnInfo(name = "puntuacion_jugador") var puntuacionJugador: Int = 0, //Puntuacion del jugador en la partida
    @ColumnInfo(name = "puntuacion_maquina") var puntuacionMaquina: Int = 0 //Puntuacion de la máquina en la partida
    )