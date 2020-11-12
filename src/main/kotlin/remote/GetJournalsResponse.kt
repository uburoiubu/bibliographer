package remote

import kotlinx.serialization.Serializable


@Serializable
data class GetJournalsResponse(
    val status: String
)