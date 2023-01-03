package me.hechfx.project.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("_id")
    val id: String,
    val social: SocialDatabase,
    val economy: EconomyDatabase,
    val premium: Boolean,
    val premiumType: Int? = null,
    val premiumDuration: Long,
    val banned: BannedDatabase
) {
    @Serializable
    data class SocialDatabase(
        val bio: String,
        val likes: Int,
        val colorProfile: String
    )

    @Serializable
    data class EconomyDatabase(
        val coins: Long,
        val dailyDelay: Long
    )

    @Serializable
    data class BannedDatabase(
        val state: Boolean,
        val reason: String? = null
    )
}
