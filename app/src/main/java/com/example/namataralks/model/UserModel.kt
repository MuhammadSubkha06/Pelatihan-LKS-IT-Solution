package com.example.namataralks.model

class UserModel {
    data class LoginRequest(
        val username : String = "",
        val password : String = ""
    )

    data class LoginResponse(
        val data: LoginData
    )

    data class LoginData(
        val token: String = ""
    )

    data class RegisterRequest(
        val username: String = "",
        val password: String = "",
        val fullName: String = "",
        val dateOfBirth: String = "2026-02-11"
    )

    data class RegisterResponse(
        val statusCode: Int = 0,
        val message: String = ""
    )
}