package com.example.tarea4_3_puntuaciones_pmdm.database.entidades

import androidx.room.Embedded
import androidx.room.Relation

data class JugadorConPartidas(
    @Embedded val jugadorEntity: JugadorEntity,
    @Relation(
        parentColumn = "id",       // Nombre de la columna correspondiente al id del jugador en la tabla jugador
        entityColumn = "idJugador" // Nombre de la columna correspondiente al id del jugador en la tabla partida
    )
    val partidaEntity: PartidaEntity
)