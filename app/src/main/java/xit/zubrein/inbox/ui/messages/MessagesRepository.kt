package xit.zubrein.inbox.ui.messages

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelMessage
import xit.zubrein.inbox.model.ModelSignin
import xit.zubrein.inbox.network.apis.ApiService
import javax.inject.Inject

class MessagesRepository @Inject constructor(private val apiService: ApiService) {

    fun getMessage() : Flow<ModelMessage> = flow {
        val response = apiService.getMessages()
        emit(response)
    }.flowOn(Dispatchers.IO)

}