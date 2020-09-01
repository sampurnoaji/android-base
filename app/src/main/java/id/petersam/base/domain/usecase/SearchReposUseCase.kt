package id.petersam.base.domain.usecase

import id.petersam.base.domain.repository.UserRepository
import javax.inject.Inject

class SearchReposUseCase @Inject constructor(private val repository: UserRepository)
