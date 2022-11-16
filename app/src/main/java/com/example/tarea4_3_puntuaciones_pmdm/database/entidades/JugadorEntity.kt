package com.example.tarea4_3_puntuaciones_pmdm.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "jugador_Entity")
data class JugadorEntity (
    @PrimaryKey(autoGenerate = true) var id: Long = 0, //ID del jugador
    var usuario:String = ""                            //Usuario del jugador
)