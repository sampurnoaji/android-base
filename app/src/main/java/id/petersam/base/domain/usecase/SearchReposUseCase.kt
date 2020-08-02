package id.petersam.base.domain.usecase

import id.petersam.base.data.vo.LoadResult
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.domain.repository.UserRepository
import id.petersam.base.external.base.BaseUseCase
import javax.inject.Inject

class SearchReposUseCase @Inject constructor(private val repository: UserRepository) : BaseUseCase<String, List<GithubRepo>>() {
    override suspend fun invoke(params: String): List<GithubRepo> {
        return when (val result = repository.searchRepos(params)) {
            is LoadResult.Success -> result.data
            else -> emptyList()
        }
    }
}
