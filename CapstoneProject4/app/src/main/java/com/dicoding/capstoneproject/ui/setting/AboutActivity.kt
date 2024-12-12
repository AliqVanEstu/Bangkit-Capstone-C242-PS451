package com.dicoding.capstoneproject.ui.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.findNavController
import com.dicoding.capstoneproject.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengaktifkan tombol kembali di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title="About"
    }

    // Menangani tombol kembali
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Kembali ke activity sebelumnya
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed() // Kembali ke activity sebelumnya
    }
}