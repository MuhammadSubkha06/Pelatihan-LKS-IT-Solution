package com.example.namataralks.storage

import android.content.Context
import android.content.SharedPreferences

class LocalStorage(private val context: Context)   {

    val myStorage = "StorageSaya"

    private val sharedPreferences =
        context.getSharedPreferences(myStorage, Context.MODE_PRIVATE)


    fun saveString(key: String, value: String){
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String?{
        return sharedPreferences.getString(key,null)
    }
}