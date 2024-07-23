package com.example.ca2grupoh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ca2grupoh.databinding.ItemLibroBinding

class LibroAdapter(private var libros: List<Map<String, Any>>) : RecyclerView.Adapter<LibroAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLibroBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLibroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro = libros[position]
        holder.binding.textViewTitulo.text = libro["titulo"].toString()
        holder.binding.textViewAutor.text = libro["autor"].toString()
        holder.binding.textViewPrecio.text = libro["precio"].toString()
        holder.binding.textViewDescripcion.text = libro["descripcion"].toString()
        holder.binding.textViewUrl.text = libro["urlPortada"].toString()
    }
    override fun getItemCount(): Int = libros.size

    fun actualizarDatos(nuevosLibros: List<Map<String, Any>>) {
        libros = nuevosLibros
        notifyDataSetChanged()
    }
}
