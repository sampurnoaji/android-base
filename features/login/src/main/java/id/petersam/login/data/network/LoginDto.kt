package id.petersam.login.data.network

import com.squareup.moshi.Json

data class LoginDto(
    @field:Json(name = "success")
    val isSuccess: Boolean? = null,
    @field:Json(name = "username")
    val username: String? = null,
    @field:Json(name = "token")
    val token: String? = null
)