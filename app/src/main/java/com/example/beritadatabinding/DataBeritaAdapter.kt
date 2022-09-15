package com.example.beritadatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beritadatabinding.databinding.ItemBinding



class DataBeritaAdapter(var dataBerita : MutableList<DataBerita>,val click : MyClick): RecyclerView.Adapter<DataBeritaAdapter.DataBeritaViewHolder>() {
    inner class DataBeritaViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(satu : DataBerita){
            binding.berita = satu
            binding.cardSatu.setOnClickListener {
                click.onClick(satu)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBeritaViewHolder {
        return DataBeritaViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DataBeritaViewHolder, position: Int) {
        holder.bind(dataBerita[position])

    }

    override fun getItemCount(): Int = dataBerita.size



    fun dataSatu(datafirst : MutableList<DataBerita>){
        this.dataBerita = datafirst
    }

    interface MyClick{
        fun onClick(dataBerita: DataBerita)
    }

}






