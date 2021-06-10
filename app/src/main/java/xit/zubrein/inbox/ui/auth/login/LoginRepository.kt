package xit.zubrein.inbox.ui.auth.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelSignin
import xit.zubrein.inbox.model.ModelSignup
import xit.zubrein.inbox.network.apis.ApiService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {

    fun login(userData : ModelAuthCredentials) : Flow<ModelSignin> = flow {
        val response = apiService.login(userData)
        emit(response)
    }.flowOn(Dispatchers.IO)

}