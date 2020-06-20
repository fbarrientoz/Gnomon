package com.uabc.edu.gnomon.ui.explorar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uabc.edu.gnomon.R


class Adapter (private val mDataSet: Array<String>)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // En este ejemplo cada elemento consta solo de un nombre
    class ViewHolder(var textView: CardView) : RecyclerView.ViewHolder(textView)

    // El layout manager invoca este método para renderizar cada elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text_view, parent, false) as CardView

        // Aquí podemos definir tamaños, márgenes, paddings, etc
        return ViewHolder(v)
    }

    // Este método asigna valores para cada elemento de la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    // Cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejm, si implementamos filtros o búsquedas)
    override fun getItemCount() = mDataSet.size
}