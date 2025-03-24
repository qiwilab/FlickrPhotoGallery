package com.example.flickrphotogallery.api

import retrofit2.http.GET
import retrofit2.http.Query

//private const val API_KEY =e "857d6173444874e7e8ae6fc06e99e3ff"

interface FlickrApi {

    @GET("services/rest/?method=flickr.interestingness.getList")
    suspend fun fetchPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 100
    ): FlickrResponce

    @GET("services/rest/?method=flickr.photos.search")
    suspend fun searchPhotos(
        @Query("text") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 100
    ): FlickrResponce
}

//    @GET("services/rest/")
//    suspend fun fetchPhotos(
//        @Query("method") method: String = "flickr.interestingness.getList",
//        @Query("api_key") apiKey: String = "$API_KEY",
//        @Query("format") format: String = "json",
//        @Query("nojsoncallback") noJsonCallback: Int = 1,
//        @Query("extras") extras: String = "url_s",
//        @Query("page") page: Int = 1,
//        @Query("per_page") perPage: Int = 100