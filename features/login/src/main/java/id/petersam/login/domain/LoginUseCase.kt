package id.petersam.login.domain

import id.petersam.core.vo.LoadResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(username: String, password: String): LoadResult<Boolean> {
        return repository.login(username, password)
    }
}