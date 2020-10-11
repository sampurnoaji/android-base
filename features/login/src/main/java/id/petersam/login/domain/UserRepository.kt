package id.petersam.login.domain

import id.petersam.core.vo.LoadResult

interface UserRepository {
    suspend fun login(username : String, password : String) : LoadResult<Boolean>
}