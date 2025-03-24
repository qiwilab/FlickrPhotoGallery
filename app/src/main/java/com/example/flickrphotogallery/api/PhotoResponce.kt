package com.example.flickrphotogallery.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponce(
    @Json(name = "photo")val galleryItems: List<GalleryItem>
)
