package id.petersam.base.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.petersam.base.data.vo.LoadResult
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.domain.usecase.SearchReposUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val searchReposUseCase: SearchReposUseCase) :
    ViewModel() {

    private val _githubRepos = MutableLiveData<LoadResult<List<GithubRepo>>>()
    val githubRepos: LiveData<LoadResult<List<GithubRepo>>>
        get() = _githubRepos

    fun getRepos(query: String) {
        _githubRepos.value = LoadResult.Loading

        viewModelScope.launch {
            _githubRepos.value = LoadResult.Success(searchReposUseCase(query))
        }
    }
}
