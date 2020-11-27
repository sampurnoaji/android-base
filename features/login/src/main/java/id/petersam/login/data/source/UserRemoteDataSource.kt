package id.petersam.login.data.source

import id.petersam.core.network.RemoteDataSource
import id.petersam.core.vo.RemoteResult
import id.petersam.login.data.network.LoginDto
import id.petersam.login.data.network.LoginRequest
import id.petersam.login.data.network.UserService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val service: UserService) : RemoteDataSource() {
    suspend fun login(dispatcher: CoroutineDispatcher, username : String, password : String): RemoteResult<LoginDto> {
        return safeApiCall(dispatcher) { service.login(LoginRequest(username, password)) }
    }
}