package id.petersam.base.data.response

import com.squareup.moshi.Json

data class GithubDto(
    @field:Json(name = "items")
    val items: List<Repo> = emptyList(),
    val nextPage: Int? = null
) {
    data class Repo(
        @field:Json(name = "id") val id: Long? = null,
        @field:Json(name = "name") val name: String? = null,
        @field:Json(name = "full_name") val fullName: String? = null,
        @field:Json(name = "description") val description: String? = null,
        @field:Json(name = "html_url") val url: String? = null,
        @field:Json(name = "stargazers_count") val stars: Int? = null,
        @field:Json(name = "forks_count") val forks: Int? = null,
        @field:Json(name = "language") val language: String? = null
    )
}
