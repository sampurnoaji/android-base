package id.petersam.base.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope

class GithubDataFactory(
    private val scope: CoroutineScope,
    private val repository: UserRepository
) : DataSource.Factory<Int, GithubRepo>() {

    lateinit var query: String

    private val _dataSource = MutableLiveData<GithubDataSource>()
    val dataSource: LiveData<GithubDataSource>
        get() = _dataSource

    override fun create(): DataSource<Int, GithubRepo> {
        val dataSource = GithubDataSource(query, scope, repository)
        _dataSource.postValue(dataSource)
        return dataSource
    }

    fun refreshData() = _dataSource.value?.invalidate()
}
