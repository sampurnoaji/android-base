package id.petersam.base.domain.usecase

import id.petersam.base.domain.repository.UserRepository
import javax.inject.Inject

class LoginStateUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(): Boolean = repository.isLoggedIn()
}
