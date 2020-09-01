package id.petersam.base.data.mapper

import id.petersam.base.data.response.GithubDto
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.external.base.BaseMapper
import javax.inject.Inject

class GithubRepoMapper @Inject constructor() : BaseMapper<GithubDto, List<GithubRepo>>() {
    override fun map(input: GithubDto): List<GithubRepo> {
        val repos = mutableListOf<GithubRepo>()
        input.items.forEach {
            repos.add(
                GithubRepo(
                    id = it.id ?: 0L,
                    name = it.name ?: "",
                    fullName = it.fullName ?: "",
                    description = it.description ?: "",
                    url = it.url ?: "",
                    stars = it.stars ?: 0,
                    forks = it.forks ?: 0,
                    language = it.language ?: ""
                )
            )
        }
        return repos
    }
}
