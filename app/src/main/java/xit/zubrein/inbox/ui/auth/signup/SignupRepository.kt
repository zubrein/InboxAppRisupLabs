package xit.zubrein.inbox.ui.auth.signup

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelSignup
import xit.zubrein.inbox.network.apis.ApiService
import javax.inject.Inject

class SignupRepository @Inject constructor(private val apiService: ApiService) {

    fun createAccount(userData : ModelAuthCredentials) : Flow<ModelSignup> = flow {
        val response = apiService.createAccount(userData)
        emit(response)
    }.flowOn(Dispatchers.IO)

}