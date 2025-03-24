package com.example.flickrphotogallery.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrResponce(
    val photos: PhotoResponce
)
