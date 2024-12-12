package com.dicoding.capstoneproject.ui.setting

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.dicoding.capstoneproject.R
import com.google.android.material.switchmaterial.SwitchMaterial
import androidx.appcompat.app.AppCompatDelegate

class SettingFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var switchTheme: SwitchMaterial

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        // Inisialisasi SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        switchTheme = view.findViewById(R.id.switch_theme)

        // Set default theme jika belum ada preferensi
        if (!sharedPreferences.contains("isDarkTheme")) {
            sharedPreferences.edit().putBoolean("isDarkTheme", false).apply() // Set default ke terang
        }

        // Set status switch berdasarkan preferensi yang disimpan
        switchTheme.isChecked = sharedPreferences.getBoolean("isDarkTheme", false)

        // Terapkan tema berdasarkan preferensi
        applyTheme(switchTheme.isChecked)

        val cardView = view.findViewById<CardView>(R.id.cardView)

        // Navigasi ke AboutActivity
        cardView.setOnClickListener {
            val intent = Intent(activity, AboutActivity::class.java)
            startActivity(intent)
        }

        // Listener untuk switch tema
        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            // Simpan preferensi tema
            sharedPreferences.edit().putBoolean("isDarkTheme", isChecked).apply()
            // Terapkan tema baru
            applyTheme(isChecked)
        }

        return view
    }

    private fun applyTheme(isDarkTheme: Boolean) {
        // Set tema berdasarkan status switch
        if (isDarkTheme) {
            // Set mode malam
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            // Set mode siang
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}