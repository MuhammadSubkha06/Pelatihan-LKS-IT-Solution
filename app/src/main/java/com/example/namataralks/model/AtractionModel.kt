package com.example.namataralks.model

class AtractionModel {
    data class attrRaesp(
        val name: String = "",
        val price: Int = 0,
        val location: String = "",
        val openingHours: String = "",
        val description: String = "",
        val rating: Int = 0,
        val imageUrl: String = ""
    )
}