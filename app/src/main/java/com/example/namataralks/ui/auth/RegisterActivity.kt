package com.example.namataralks.ui.auth

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.namataralks.databinding.ActivityRegisterBinding
import com.example.namataralks.model.UserModel
import com.example.namataralks.network.RetrofitClient
import com.example.namataralks.storage.LocalStorage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegisterActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityRegisterBinding
    private var dateOfBirthApiFormat: String? = null
    private lateinit var preferences: LocalStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = LocalStorage(context = this)

        binding.btnRegist.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val fullName = binding.etFullname.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etPasswordConf.text.toString().trim()

            val dobApiString = dateOfBirthApiFormat

            if (username.isEmpty() || fullName.isEmpty() || dobApiString.isNullOrEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan Konfirmasi Password tidak sesuai", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            submitRegistry(username, fullName, dobApiString, password)
        }
        binding.btnLoginNav.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.etDob.setOnClickListener {
            showDatePickerDialog()
        }

    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)

                val apiDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                dateOfBirthApiFormat = apiDateFormat.format(selectedDate.time)
                val userDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                binding.etDob.setText(userDateFormat.format(selectedDate.time))
            },
            year,
            month,
            day
        ).show()
    }
    private fun submitRegistry(
        username: String,
        fullName: String,
        dateOfBirth: String?,
        password: String
    ) {
        RetrofitClient.retrofit.registryUser(
            UserModel.RegisterRequest(
                username = username,
                fullName = fullName,
                password = password,
                dateOfBirth = dateOfBirth ?: ""
            )
        ).enqueue(object : Callback<UserModel.RegisterResponse> {
            override fun onResponse(
                call: Call<UserModel.RegisterResponse>,
                response: Response<UserModel.RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterActivity, "Pendaftaran Berhasil! Silakan Login.", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    finish()
                } else {
                    val errorBody = response.errorBody()?.string()
                    val statusCode = response.code()

                    Log.e("API_REGISTER", "Gagal Pendaftaran. Status Code: $statusCode, Body: $errorBody")

                    Toast.makeText(this@RegisterActivity, "Pendaftaran Gagal. Coba Username lain atau periksa log.", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<UserModel.RegisterResponse>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Kesalahan koneksi: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

}