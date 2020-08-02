package id.petersam.base.data.source.remote

import id.petersam.base.data.request.LoginRequest
import id.petersam.base.data.response.GithubDto
import id.petersam.base.data.response.LoginDto
import id.petersam.base.data.service.ApiService
import id.petersam.base.data.vo.LoadResult
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val service: ApiService) :
    RemoteDataSource() {
    suspend fun login(dispatcher: CoroutineDispatcher, request: LoginRequest): LoadResult<LoginDto> {
        return safeApiCall(dispatcher) { service.login(request) }
    }

    suspend fun searchRepo(dispatcher: CoroutineDispatcher, query: String): LoadResult<GithubDto> {
        return safeApiCall(dispatcher) { service.searchRepos(query) }
    }
}
