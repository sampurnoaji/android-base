package id.petersam.base.domain.repository

import id.petersam.base.data.request.LoginRequest
import id.petersam.base.data.vo.LoadResult
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.domain.entity.LoginData

interface UserRepository {
    suspend fun login(request: LoginRequest): LoadResult<LoginData>
    suspend fun searchRepos(query: String, page: Int, size: Int): LoadResult<List<GithubRepo>>

    fun setLoggedIn(isLoggedIn: Boolean)
    fun saveUserSession(name: String, token: String)
    fun isLoggedIn(): Boolean
    fun getUsername(): String
    fun getToken(): String
}
