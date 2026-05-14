package com.example.namataralks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namataralks.databinding.GridCategoryBinding
import com.example.namataralks.model.CategoryModel
import java.util.ArrayList

class CategoryListAdapter(private val dataCategory: ArrayList<CategoryModel.CategoryData>): RecyclerView.Adapter<CategoryVewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryVewHolder {
        val binding = GridCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryVewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryVewHolder,
        position: Int
    ) {
        holder.bind(dataCategory[position])
    }

    override fun getItemCount(): Int = dataCategory.size



}