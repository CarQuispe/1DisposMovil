package network

import com.squareup.moshi.Json

data class GithubUser(
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatarUrl: String
)