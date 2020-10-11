package id.petersam.login.data.network

import com.squareup.moshi.Json

data class LoginRequest(
    @field:Json(name = "username")
    val username: String,
    @field:Json(name = "password")
    val password: String
)