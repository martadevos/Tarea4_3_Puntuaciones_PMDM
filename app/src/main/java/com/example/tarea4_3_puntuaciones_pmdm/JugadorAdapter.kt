package com.example.tarea4_3_puntuaciones_pmdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea4_3_puntuaciones_pmdm.database.entidades.JugadorEntity

class JugadorAdapter(
    val jugadores: List<JugadorEntity>,                   // Objeto Lista de tareas
) : RecyclerView.Adapter<JugadorAdapter.ViewHolder>() {    // Devuelve la vista

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {     // Muestra la vista (holder) y cada tarea de la lista (position)
        val jugador =
            jugadores[position]                                         // Extrae un jugador de la lista

        holder.bind(
            jugador
        )                           // Muestra el item en la vista (ver más adelante)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {    // Contenedor de la vista (holder) y la posición de la tarea en la lista (position)
        val layoutInflater =
            LayoutInflater.from(parent.context)                       // Se instancia el Layout para la vista
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_jugador_puntuacion,
                parent,
                false
            )
        )   // Devuelve la vista inflando el layout del item
    }

    override fun getItemCount(): Int {
        return jugadores.size     // Devuelve el número de tareas de la lista
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {     // Clase con la vista
        val tvUsuarioJugador =
            view.findViewById<TextView>(R.id.tvUsuarioJugador)         // instancia del Textview de la vista
        val tvPartidasJugadas =
            view.findViewById<CheckBox>(R.id.tvPartidasJugadas)     // instancia del Checkbox de la vista
        val tvMaximaPuntuacion =
            view.findViewById<CheckBox>(R.id.tvMaximaPuntuacion)     // instancia del Checkbox de la vista

        fun bind(                                   // función que une los elementos en la vista y prepara los listeners
            jugador: JugadorEntity
        ) {
            tvUsuarioJugador.text = jugador.usuario
            tvPartidasJugadas.text = jugador.numPartidas.toString()
            tvMaximaPuntuacion.text = jugador.puntuacionMasAlta.toString()
        }
    }
}