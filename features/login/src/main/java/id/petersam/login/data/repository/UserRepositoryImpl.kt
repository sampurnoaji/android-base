package id.petersam.login.data.repository

import id.petersam.core.dispatcher.DispatcherProvider
import id.petersam.core.vo.LoadResult
import id.petersam.core.vo.RemoteResult
import id.petersam.login.data.source.UserRemoteDataSource
import id.petersam.login.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun login(username: String, password: String): LoadResult<Boolean> {
        return when (val remoteResult = remoteDataSource.login(dispatcher.io, username, password)) {
            is RemoteResult.Success -> LoadResult.Success(remoteResult.data.isSuccess ?: false)
            is RemoteResult.Error -> LoadResult.Error(remoteResult.cause, remoteResult.code, remoteResult.errorMessage)
            else -> LoadResult.Error()
        }
    }
}