package xit.zubrein.inbox.model

import com.google.gson.annotations.SerializedName

data class ModelSignup(
    @SerializedName("@context") val context : String,
    @SerializedName("@type") val type : String,
    @SerializedName("id") val id: String,
    @SerializedName("address") val address: String,
    @SerializedName("quota") val quota: Int,
    @SerializedName("used") val used: Int,
    @SerializedName("isDisabled") val isDisabled: Boolean,
    @SerializedName("isDeleted") val isDeleted: Boolean,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String
)

//{
//    "@context": "/contexts/Account",
//    "@id": "/accounts/60c21d3b83650f19b05dd6ac",
//    "@type": "Account",
//    "id": "60c21d3b83650f19b05dd6ac",
//    "address": "robi1@logicstreak.com",
//    "quota": 40000000,
//    "used": 0,
//    "isDisabled": false,
//    "isDeleted": false,
//    "createdAt": "2021-06-10T14:10:03+00:00",
//    "updatedAt": "2021-06-10T14:10:03+00:00"
//}