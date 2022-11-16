package com.example.tarea4_3_puntuaciones_pmdm

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea4_3_puntuaciones_pmdm.database.entidades.JugadorEntity
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    //lateinit var adapter: TasksAdapter
    lateinit var jugadores: MutableList<JugadorEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jugadores = ArrayList()         // Se prepara la lista
        getJugadoresPuntuaciones()                  // Se carga la lista de tareas a través del DAO
        findViewById<Button>(R.id.btnAddUsuario).setOnClickListener {
            addTask(JugadorEntity(usuario = findViewById< EditText>(R.id.txtUsuario).text.toString()))}
    }

    fun clearFocus(){
        findViewById<EditText>(R.id.txtUsuario).setText("") // Borra el texto en el EditText
    }

    fun Context.hideKeyboard() {    // Oculta el teclado de texto
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    fun getJugadoresPuntuaciones()= runBlocking {       // Corrutina que saca de la base de datos la lista de tareas
        launch {                        // Inicio del hilo
            jugadores = PiedraPapelTijerasApp.database.jugadorDao().getAllTasks()    // Se carga la lista de tareas
            setUpRecyclerView(jugadores)        // se pasa la lista a la Vista
        }
    }

    fun addTask(task:TaskEntity)= runBlocking{  // Corrutina que añade una tarea a la lista
        launch {
            val id = PiedraPapelTijerasApp.database.taskDao().addTask(task)   // Inserta una tarea nueva
            val recoveryTask = PiedraPapelTijerasApp.database.taskDao().getTaskById(id)   // Recarga la lista
            jugadores.add(recoveryTask) // Añade al final de la lista, el nuevo
            adapter.notifyItemInserted(jugadores.size)  // El adaptador notifica que se ha insertado
            clearFocus()        // Se elimina el texto del et ...
            hideKeyboard()      // y se oculta el teclado
        }
    }

    fun updateTask(task: TaskEntity) = runBlocking{
        launch {
            task.isDone = !task.isDone  // Marca o desmarca el checkbox
            PiedraPapelTijerasApp.database.taskDao().updateTask(task) // Actualiza en la base de datos
        }
    }

    fun deleteTask(task: TaskEntity)= runBlocking{
        launch {
            val position = jugadores.indexOf(task)  // Busca la posición de la tarea en la lista...
            PiedraPapelTijerasApp.database.taskDao().deleteTask(task) // ... y la borra de la base de datos.
            jugadores.remove(task)      // Finalmente, la elimina de la lista
            adapter.notifyItemRemoved(position) // El adaptador notifica que se ha eliminado la tarea
        }
    }

    fun setUpRecyclerView(jugadores: List<JugadorEntity>) {    // Método que muestra la vista usando el adaptador
        adapter = TasksAdapter(tasks, { updateTask(it) }, {deleteTask(it)})
        recyclerView = findViewById(R.id.rvTask)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}

