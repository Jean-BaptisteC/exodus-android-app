package org.eu.exodusprivacy.exodus.manager.network

import org.eu.exodusprivacy.exodus.manager.network.data.AppDetails
import org.eu.exodusprivacy.exodus.manager.network.data.Trackers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExodusAPIInterface {

    companion object {
        const val BASE_URL = "https://reports.exodus-privacy.eu.org/api/"
    }

    @GET("trackers")
    suspend fun getAllTrackers(): Response<Trackers>

    @GET("search/{packageName}/details")
    suspend fun getAppDetails(
        @Path("packageName") packageName: String
    ): Response<List<AppDetails>>
}
