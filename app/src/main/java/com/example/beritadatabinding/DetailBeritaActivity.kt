package com.example.beritadatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.beritadatabinding.databinding.ActivityDetailBeritaBinding

class DetailBeritaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBeritaBinding
    private lateinit var dataBeritaAdapter: DataBeritaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail_berita)
        val x = intent.getSerializableExtra("berita") as DataBerita
        binding.detailBerita = x
    }
}