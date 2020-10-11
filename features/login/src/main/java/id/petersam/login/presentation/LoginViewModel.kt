package id.petersam.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.petersam.core.vo.LoadResult
import id.petersam.login.domain.LoginUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _loginResult = MutableLiveData<LoadResult<Boolean>>()
    val loginResult: LiveData<LoadResult<Boolean>>
        get() = _loginResult

    fun login(username: String, password: String) {
        _loginResult.value = LoadResult.Loading
        viewModelScope.launch {
            _loginResult.value = loginUseCase(username, password)
        }
    }
}