package id.petersam.base.data.service

import id.petersam.base.data.request.LoginRequest
import id.petersam.base.data.response.LoginDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginDto
}
