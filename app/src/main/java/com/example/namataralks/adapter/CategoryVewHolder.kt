package com.example.namataralks.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.namataralks.databinding.GridCategoryBinding
import com.example.namataralks.model.CategoryModel

class CategoryVewHolder(private val binding: GridCategoryBinding)
    : RecyclerView.ViewHolder(binding.root){

    fun bind(data: CategoryModel.CategoryData){
        binding.txtNama.text = data.name
        binding.txtDesc.text = data.description
        val urlImage = "http://10.0.2.2:5000/" + data.imageUrl.lowercase()
        binding.imgDest.load(urlImage)
    }
}