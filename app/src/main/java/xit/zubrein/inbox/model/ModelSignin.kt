package xit.zubrein.inbox.model

import com.google.gson.annotations.SerializedName

data class ModelSignin(

    @SerializedName("token")
    var token : String?,
    @SerializedName("id")
    var id : String?,
    @SerializedName("message")
    var message : String?,

)
