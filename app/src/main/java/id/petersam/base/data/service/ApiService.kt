package id.petersam.base.data.service

import id.petersam.base.data.request.LoginRequest
import id.petersam.base.data.response.GithubDto
import id.petersam.base.data.response.LoginDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginDto

    @GET("search/repositories?sort=stars")
    suspend fun searchRepos(
        @Query("q") query: String
    ): GithubDto
}
