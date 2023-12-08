package org.creativeblogger.org.data.repository

import org.creativeblogger.org.data.remote.Api
import org.creativeblogger.org.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private var api: Api
) : MyRepository {
    override suspend fun getPosts(): String {
        return api.getPosts()
    }
}