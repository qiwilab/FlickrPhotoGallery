package com.example.flickrphotogallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//private const val TAG = "PhotoGalleryViewModel"

@HiltViewModel
class PhotoGalleryViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {
    val galleryItemsFlow = photoRepository.getPagedPhotos().cachedIn(viewModelScope)
}