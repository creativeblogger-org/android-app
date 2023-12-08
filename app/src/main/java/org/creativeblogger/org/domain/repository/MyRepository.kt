package org.creativeblogger.org.domain.repository

interface MyRepository {
    suspend fun getPosts(): String
}