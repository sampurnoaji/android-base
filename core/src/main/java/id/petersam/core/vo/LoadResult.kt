package id.petersam.core.vo

sealed class LoadResult<out T> {
    object Loading : LoadResult<Nothing>()
    data class Success<out T>(val data: T) : LoadResult<T>()
    data class Error(val cause: HttpResult = HttpResult.NOT_DEFINED, val code : Int? = null, val errorMessage : String? = null) : LoadResult<Nothing>()
}