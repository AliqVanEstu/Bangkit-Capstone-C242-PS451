package com.dicoding.capstoneproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dicoding.capstoneproject.R

class DetailAksaraFragment : Fragment() {

    private var aksaraType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            aksaraType = it.getString(ARG_AKSARA_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_aksara, container, false)

        // Tampilkan detail berdasarkan aksaraType
        val textView = view.findViewById<TextView>(R.id.tv_detail_deskripsi)
        val imageView = view.findViewById<ImageView>(R.id.iv_detail_image)

        // Set deskripsi dan gambar berdasarkan aksaraType
        when (aksaraType) {
            "Aksara Jawa" -> {
                textView.text = getString(R.string.aksara_jawa_description)
                imageView.setImageResource(R.drawable.aksara_jawa)
                imageView.contentDescription = getString(R.string.aksara_image_description)
            }
            "Pasangan Aksara" -> {
                textView.text = getString(R.string.pasangan_aksara_description)
                imageView.setImageResource(R.drawable.pasangan_aksara)
                imageView.contentDescription = getString(R.string.pasangan_aksara_image_description)
            }
            "Sandhangan" -> {
                textView.text = getString(R.string.sandhangan_description)
                imageView.setImageResource(R.drawable.sandhangan)
                imageView.contentDescription = getString(R.string.sandhangan_image_description)
            }
            "Wilangan" -> {
                textView.text = getString(R.string.wilangan_description)
                imageView.setImageResource(R.drawable.wilangan)
                imageView.contentDescription = getString(R.string.wilangan_image_description)
            }
            "Swara" -> {
                textView.text = getString(R.string.swara_description)
                imageView.setImageResource(R.drawable.swara)
                imageView.contentDescription = getString(R.string.swara_image_description)
            }
            else -> {
                textView.text = getString(R.string.default_description)
                imageView.setImageResource(R.drawable.baseline_image_24)
                imageView.contentDescription = getString(R.string.default_image_description)
            }
        }

        return view
    }

    companion object {
        const val ARG_AKSARA_TYPE = "aksara_type" // Pastikan ini tetap sama
    }
}