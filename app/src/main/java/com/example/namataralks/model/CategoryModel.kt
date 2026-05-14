package com.example.namataralks.model


class CategoryModel {

    data class CategoryResponse(
        val statuscode: String = "",
        val message: String = "",
        val data: ArrayList<CategoryData> = arrayListOf()
    )

    data class CategoryData(
        val id: String = "",
        val name: String = "",
        val imageUrl: String = "",
        val description: String = ""
    )


}