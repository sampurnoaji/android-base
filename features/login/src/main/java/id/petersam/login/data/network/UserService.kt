package id.petersam.login.data.network

import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/api/v1/login")
    suspend fun login(@Body request: LoginRequest): LoginDto
}