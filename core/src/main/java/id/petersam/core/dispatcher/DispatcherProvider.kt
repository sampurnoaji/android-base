package id.petersam.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val io: CoroutineDispatcher
    val ui: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}