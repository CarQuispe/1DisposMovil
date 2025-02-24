package network

import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): network.GithubUser
}