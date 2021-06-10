package xit.zubrein.inbox.network.apis

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import xit.zubrein.inbox.model.*
import xit.zubrein.inbox.network.data.ApiConstants

interface ApiService {

    @GET(ApiConstants.DOMAIN)
    suspend fun getDomain() : ModelDomain

    @POST(ApiConstants.CREATE_ACCOUNT)
    suspend fun createAccount(
        @Body body : ModelAuthCredentials
    ) : ModelSignup

    @POST(ApiConstants.LOGIN)
    suspend fun login(
        @Body body : ModelAuthCredentials
    ) : ModelSignin

    @GET(ApiConstants.INBOX)
    suspend fun getMessages() : ModelMessage

}