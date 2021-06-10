package xit.zubrein.inbox.model

import com.google.gson.annotations.SerializedName

data class ModelDomain(
    @SerializedName("hydra:member") val member: List<Hydra>,
    @SerializedName("hydra:totalItems")
    val totalItems: Int
) {
    data class Hydra(
        @SerializedName("id") val id: String,
        @SerializedName("domain") val domain: String,
        @SerializedName("isActive") val isActive: Boolean,
        @SerializedName("isPrivate") val isPrivate: Boolean,
        @SerializedName("createdAt") val createdAt: String,
        @SerializedName("updatedAt") val updatedAt: String
    )
}
