package id.petersam.base.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import id.petersam.base.data.vo.LoadResult
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class GithubDataSource(
    private val query: String,
    private val scope: CoroutineScope,
    private val repository: UserRepository
) : PageKeyedDataSource<Int, GithubRepo>() {

    companion object {
        const val SIZE = 5
    }

    private val _networkState = MutableLiveData<LoadResult<List<GithubRepo>>>()
    val networkState: LiveData<LoadResult<List<GithubRepo>>>
        get() = _networkState

    private val _initialLoading = MutableLiveData<LoadResult<List<GithubRepo>>>()
    val initialLoading: LiveData<LoadResult<List<GithubRepo>>>
        get() = _initialLoading

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GithubRepo>
    ) {
        _networkState.postValue(LoadResult.Loading)
        _initialLoading.postValue(LoadResult.Loading)

        scope.launch {
            val result = repository.searchRepos(query, 1, params.requestedLoadSize)
            when (result) {
                is LoadResult.Success -> {
                    _initialLoading.postValue(LoadResult.Success(result.data))
                    callback.onResult(result.data, null, 2)
                }
                is LoadResult.Error -> {
                    _initialLoading.postValue(LoadResult.Error(result.cause, result.code, result.errorMessage))
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GithubRepo>) {
        _networkState.postValue(LoadResult.Loading)
        scope.launch {
            val result = repository.searchRepos(query, params.key, params.requestedLoadSize)
            when (result) {
                is LoadResult.Success -> {
                    _networkState.postValue(LoadResult.Success(result.data))
                    callback.onResult(result.data, params.key + 1)
                }
                is LoadResult.Error -> {
                    _networkState.postValue(LoadResult.Error(result.cause, result.code, result.errorMessage))
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GithubRepo>) {}
}
