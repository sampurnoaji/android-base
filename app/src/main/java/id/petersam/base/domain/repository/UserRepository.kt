package id.petersam.base.domain.repository

import id.petersam.base.data.request.LoginRequest
import id.petersam.base.domain.entity.LoginData
import id.petersam.base.data.vo.LoadResult

interface UserRepository {
    suspend fun login(request: LoginRequest): LoadResult<LoginData>

    fun setLoggedIn(isLoggedIn: Boolean)
    fun saveUserSession(name: String, token: String)
    fun isLoggedIn(): Boolean
    fun getUsername(): String
    fun getToken(): String
}
