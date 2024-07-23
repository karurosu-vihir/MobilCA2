package com.example.ca2grupoh

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.example.ca2grupoh.LibroAdapter
import com.example.ca2grupoh.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LibroAdapter
    private val librosList = mutableListOf<Map<String, Any>>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = LibroAdapter(librosList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        fetchLibrosFromFirestore()
    }

    private fun fetchLibrosFromFirestore() {
        db.collection("libros")
            .get()
            .addOnSuccessListener { result ->
                val libro = result.map{it.data}
                Log.d("Libros", "Libros: $libro")
                adapter.actualizarDatos(libro)
            }
            .addOnFailureListener { exception ->
                Log.e("StudentListFragment", "Error getting documents.", exception)
            }
    }
}
