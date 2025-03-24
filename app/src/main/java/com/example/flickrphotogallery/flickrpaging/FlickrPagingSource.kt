package com.example.flickrphotogallery.flickrpaging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.flickrphotogallery.api.FlickrApi
import com.example.flickrphotogallery.api.GalleryItem

class FlickrPagingSource(
    private val flickrApi: FlickrApi
) : PagingSource<Int, GalleryItem>() {

    override fun getRefreshKey(state: PagingState<Int, GalleryItem>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GalleryItem> {
        val page = params.key ?: 1

        return try {
            val response = flickrApi.fetchPhotos(page = page, perPage = params.loadSize)
            val photos = response.photos.galleryItems
            LoadResult.Page(
                data = photos,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (photos.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}