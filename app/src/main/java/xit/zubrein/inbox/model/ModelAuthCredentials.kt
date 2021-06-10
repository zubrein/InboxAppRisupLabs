package xit.zubrein.inbox.model

import com.google.gson.annotations.SerializedName

data class ModelAuthCredentials(

    @SerializedName("address")
    var address: String,
    @SerializedName("password")
    var password: String,
)
