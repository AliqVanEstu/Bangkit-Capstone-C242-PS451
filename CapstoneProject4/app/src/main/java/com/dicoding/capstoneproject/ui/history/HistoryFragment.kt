package com.dicoding.capstoneproject.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dicoding.capstoneproject.R

class HistoryFragment : Fragment() {

    private var historyItem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            historyItem = it.getString("historyItem")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        // Mengatur teks dan gambar berdasarkan data
        val textView: TextView = view.findViewById(R.id.history_text)
        textView.text = historyItem ?: "No history available"

        // Jika Anda ingin mengubah gambar berdasarkan kondisi tertentu
        val imageView: ImageView = view.findViewById(R.id.history_image)
        // imageView.setImageResource(R.drawable.your_image) // Ganti dengan logika yang sesuai

        return view
    }
}