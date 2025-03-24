package com.example.flickrphotogallery

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.flickrphotogallery.api.FlickrApi
import com.example.flickrphotogallery.api.GalleryItem
import com.example.flickrphotogallery.flickrpaging.FlickrPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val flickrApi: FlickrApi
) {
    fun getPagedPhotos(): Flow<PagingData<GalleryItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { FlickrPagingSource(flickrApi) }
        ).flow
    }
}