package com.dicoding.capstoneproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.capstoneproject.R
import com.dicoding.capstoneproject.databinding.FragmentHomeBinding
import com.dicoding.capstoneproject.ui.history.HistoryAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inisialisasi CardView
        val akasarajawaCard = view.findViewById<CardView>(R.id.akasarajawa)
        val pasanganAksaraCard = view.findViewById<CardView>(R.id.pasangan_akasara)
        val sandhanganCard = view.findViewById<CardView>(R.id.sandhangan)
        val wilanganCard = view.findViewById<CardView>(R.id.wilangan)
        val swaraCard = view.findViewById<CardView>(R.id.Swara)

        // Set listener untuk CardView
        akasarajawaCard.setOnClickListener {
            navigateToDetailFragment("Aksara Jawa")
        }

        pasanganAksaraCard.setOnClickListener {
            navigateToDetailFragment("Pasangan Aksara")
        }

        sandhanganCard.setOnClickListener {
            navigateToDetailFragment("Sandhangan")
        }

        wilanganCard.setOnClickListener {
            navigateToDetailFragment("Wilangan")
        }

        swaraCard.setOnClickListener {
            navigateToDetailFragment("Swara")
        }

        // Inisialisasi RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_sejarah)
        val historyList = listOf(
            "Sejarah Aksara Jawa",
            "Budaya Jawa",
            "Tradisi Jawa"
        ) // Ganti dengan data Anda
        val adapter = HistoryAdapter(historyList) { historyItem ->
            navigateToHistoryFragment(historyItem)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun navigateToDetailFragment(aksaraType: String) {
        val bundle = Bundle().apply {
            putString(DetailAksaraFragment.ARG_AKSARA_TYPE, aksaraType) // Menggunakan kunci yang sama
        }
        findNavController().navigate(R.id.detailAksaraFragment, bundle) // Menggunakan ID fragment
    }

    private fun navigateToHistoryFragment(historyItem: String) {
        val bundle = Bundle().apply {
            putString("historyItem", historyItem) // Menyimpan data ke dalam Bundle
        }
        findNavController().navigate(R.id.historyFragment, bundle) // Menggunakan ID fragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}