package id.petersam.base.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.petersam.base.data.repository.GithubDataFactory
import id.petersam.base.data.repository.GithubDataSource
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.domain.repository.UserRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(repository: UserRepository) : ViewModel() {

    lateinit var githubRepos: LiveData<PagedList<GithubRepo>>

    private val factory = GithubDataFactory(viewModelScope, repository)
    val initialLoading = Transformations.switchMap(factory.dataSource) { it.initialLoading }
    val networkState = Transformations.switchMap(factory.dataSource) { it.networkState }

    init {
        searchGithubRepos("Android")
    }

    fun searchGithubRepos(query: String) {
        factory.query = query
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(GithubDataSource.SIZE)
            .setInitialLoadSizeHint(2 * GithubDataSource.SIZE)
            .build()
        githubRepos = LivePagedListBuilder<Int, GithubRepo>(factory, config).build()
    }

    fun refreshReposData() = factory.refreshData()
}
