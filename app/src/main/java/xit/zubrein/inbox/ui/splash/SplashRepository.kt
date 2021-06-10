package xit.zubrein.inbox.ui.splash

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.inbox.model.ModelDomain
import xit.zubrein.inbox.network.apis.ApiService
import javax.inject.Inject

class SplashRepository @Inject constructor(private val apiService: ApiService) {

    fun getDomain(): Flow<ModelDomain> = flow {
        val response = apiService.getDomain()
        emit(response)
    }.flowOn(Dispatchers.IO)

}