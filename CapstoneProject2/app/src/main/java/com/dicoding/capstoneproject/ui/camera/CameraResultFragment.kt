package com.dicoding.capstoneproject.ui.camera

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dicoding.capstoneproject.R

class CameraResultFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var resultTextView: TextView
    private lateinit var retryButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_camera_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi komponen UI
        imageView = view.findViewById(R.id.iv_photo_result_scan)
        resultTextView = view.findViewById(R.id.tv_scan_result)
        retryButton = view.findViewById(R.id.btn_deteksi_ulang)

        // Mengatur judul ActionBar
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Hasil Kamera"

        // Mendapatkan URI gambar dari argumen
        val imageUri = arguments?.getString("imageUri")
        imageUri?.let {
            imageView.setImageURI(Uri.parse(it))
            // Panggil fungsi untuk mendapatkan hasil ML
            val result = performMachineLearningAnalysis(it)
            resultTextView.text = result
        }

        // Menangani klik pada tombol retry
        retryButton.setOnClickListener {
            // Navigasi kembali ke CameraFragment
            findNavController().navigate(R.id.navigation_camera) // Ganti dengan ID yang sesuai
        }
    }

    private fun performMachineLearningAnalysis(imageUri: String): String {
        // Implementasikan logika untuk analisis ML di sini
        // Kembalikan hasil analisis sebagai String
        return "Hasil terjemahan dari gambar: $imageUri"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengaktifkan tombol kembali di ActionBar
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Kembali ke aktivitas sebelumnya
                findNavController().popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Mengembalikan judul ActionBar ke default jika diperlukan
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Nama Default"
    }
}