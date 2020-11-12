package remote

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val txt: String
)