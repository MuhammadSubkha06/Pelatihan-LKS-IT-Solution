package com.example.namataralks.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namataralks.adapter.CategoryListAdapter
import com.example.namataralks.databinding.FragmentHomeBinding
import com.example.namataralks.model.CategoryModel
import com.example.namataralks.network.RetrofitClient
import com.example.namataralks.storage.LocalStorage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var preferences: LocalStorage
    private lateinit var dataAdapter: CategoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        preferences = LocalStorage(requireContext())

        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())

        val namaUser = preferences.getString("username")?: "Pengunjung"
        binding.txtNama.text = "Selamat Datang! $namaUser\nDi Desa Wisata Namang"
        tampilData()

        return binding.root
    }


    private fun tampilData() {
        val token = preferences.getString("Token") ?: ""

        RetrofitClient.retrofit.categoryList("Bearer $token").enqueue(object : Callback<CategoryModel.CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryModel.CategoryResponse>,
                response: Response<CategoryModel.CategoryResponse>
            ) {
                if (response.isSuccessful) {
                    val listData = response.body()?.data ?: arrayListOf()

                    dataAdapter = CategoryListAdapter(listData)

                    binding.rvCategory.adapter = dataAdapter
                }
            }

            override fun onFailure(call: Call<CategoryModel.CategoryResponse>, t: Throwable) {
                if (isAdded) {
                    Toast.makeText(requireContext(), "Gagal: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}