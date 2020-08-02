package id.petersam.base.data.repository

import id.petersam.base.data.dispatcher.DispatcherProvider
import id.petersam.base.data.mapper.GithubRepoMapper
import id.petersam.base.data.mapper.LoginMapper
import id.petersam.base.data.request.LoginRequest
import id.petersam.base.data.source.local.UserLocalDataSource
import id.petersam.base.data.source.remote.UserRemoteDataSource
import id.petersam.base.data.vo.LoadResult
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.domain.entity.LoginData
import id.petersam.base.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource,
    private val loginMapper: LoginMapper,
    private val githubRepoMapper: GithubRepoMapper
) : UserRepository {
    override suspend fun login(request: LoginRequest): LoadResult<LoginData> {
        return when (val apiResult = remoteDataSource.login(dispatcher.io, request)) {
            is LoadResult.Success -> LoadResult.Success(loginMapper.map(apiResult.data))
            is LoadResult.Error -> LoadResult.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> LoadResult.Error()
        }
    }

    override suspend fun searchRepos(query: String): LoadResult<List<GithubRepo>> {
        return when (val apiResult = remoteDataSource.searchRepo(dispatcher.io, query)) {
            is LoadResult.Success -> LoadResult.Success(githubRepoMapper.map(apiResult.data))
            is LoadResult.Error -> LoadResult.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> LoadResult.Error()
        }
    }

    override fun setLoggedIn(isLoggedIn: Boolean) = localDataSource.setLoggedIn(isLoggedIn)
    override fun saveUserSession(name: String, token: String) = localDataSource.saveUserSession(name, token)
    override fun isLoggedIn(): Boolean = localDataSource.isLoggedIn()
    override fun getUsername(): String = localDataSource.getUsername()
    override fun getToken(): String = localDataSource.getToken()
}
