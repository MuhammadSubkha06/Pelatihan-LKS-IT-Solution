package com.example.namataralks.ui.dashboard

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.namataralks.databinding.FragmentDashboardBinding
import com.example.namataralks.storage.LocalStorage

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private lateinit var  preferences: LocalStorage

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        preferences = LocalStorage(context = requireContext())
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

         binding.textDashboard.text = preferences.getString("Token")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}