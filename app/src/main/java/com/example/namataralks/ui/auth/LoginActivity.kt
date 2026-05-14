package com.example.namataralks.ui.auth

import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.namataralks.MainActivity
import com.example.namataralks.databinding.ActivityLoginBinding
import com.example.namataralks.model.UserModel
import com.example.namataralks.network.RetrofitClient
import com.example.namataralks.storage.LocalStorage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityLoginBinding

    private lateinit var preferences: LocalStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = LocalStorage(context = this)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            submitLogin()
        }
        binding.btnSignUpNav.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun submitLogin (){
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        RetrofitClient.retrofit.loginUser(UserModel.LoginRequest(
            username = username,
            password = password
        )).enqueue(object : Callback<UserModel.LoginResponse>{
            override fun onResponse(
                call: Call<UserModel.LoginResponse>,
                response: Response<UserModel.LoginResponse>
            ) {
                if (response.isSuccessful) {
                    preferences.saveString("username", username)
                    preferences.saveString("Token", response.body()?.data?.token ?: "")
                    Toast.makeText(this@LoginActivity, "login berhasil" + "||" + response.body()?.data?.token, Toast.LENGTH_SHORT).show()
                    val navMain = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(navMain)
                    finish()

                } else {
                    Toast.makeText(this@LoginActivity, "password salah", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserModel.LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}