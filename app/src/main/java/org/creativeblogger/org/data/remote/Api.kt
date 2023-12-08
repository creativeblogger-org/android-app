package org.creativeblogger.org.data.remote

import org.creativeblogger.org.screens.API_URL
import retrofit2.http.GET

interface Api {

    @GET("$API_URL/posts")
    suspend fun getPosts(): String
}