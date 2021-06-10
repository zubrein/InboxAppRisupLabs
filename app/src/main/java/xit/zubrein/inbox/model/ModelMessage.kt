package xit.zubrein.inbox.model

import com.google.gson.annotations.SerializedName

data class ModelMessage(
    @SerializedName("@context") val context: String,
    @SerializedName("@id") val id: String,
    @SerializedName("@type") val type: String,
    @SerializedName("hydra:member") var member: List<HydraM>?,
    @SerializedName("hydra:totalItems") val totalItems: Int
)

data class HydraM(
    @SerializedName("@type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("accountId") val accountId: String,
    @SerializedName("msgid") val msgid: String,
    @SerializedName("from") val from: From,
    @SerializedName("to") val to: List<To>,
    @SerializedName("subject") val subject: String,
    @SerializedName("intro") val intro: String,
    @SerializedName("seen") val seen: Boolean,
    @SerializedName("isDeleted") val isDeleted: Boolean,
    @SerializedName("hasAttachments") val hasAttachments: Boolean,
    @SerializedName("size") val size: Int,
    @SerializedName("downloadUrl") val downloadUrl: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String
)

data class From(
    @SerializedName("address") val address: String,
    @SerializedName("name") val name: String
)

data class To(
    @SerializedName("address") val address: String,
    @SerializedName("name") val name: String
)


//{
//    "@context": "/contexts/Message",
//    "@id": "/messages",
//    "@type": "hydra:Collection",
//    "hydra:member": [
//    {
//        "@id": "/messages/60c05556c139b1f5df7b6bfe",
//        "@type": "Message",
//        "id": "60c05556c139b1f5df7b6bfe",
//        "accountId": "/accounts/60c052c948681619d0634674",
//        "msgid": "<CAHB6xObkK7QpvSi-qiCbg4npQDHX1wg3tCEE8SKxxB3drbH7Tw@mail.gmail.com>",
//        "from": {
//        "address": "robi3443@gmail.com",
//        "name": "Mohammad Robiul Alam"
//    },
//        "to": [
//        {
//            "address": "robi@logicstreak.com",
//            "name": ""
//        }
//        ],
//        "subject": "test",
//        "intro": "test",
//        "seen": false,
//        "isDeleted": false,
//        "hasAttachments": false,
//        "size": 2616,
//        "downloadUrl": "/messages/60c05556c139b1f5df7b6bfe/download",
//        "createdAt": "2021-06-09T05:44:43+00:00",
//        "updatedAt": "2021-06-09T05:44:54+00:00"
//    }
//    ],
//    "hydra:totalItems": 1
//}
