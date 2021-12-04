package com.weatherapp.adapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.weatherapp.api.image.ImageLoader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageViewBindingAdapter @Inject constructor(private val imageLoader: ImageLoader) {

    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, imageName: String?) {
        imageName?.let { name ->
            imageLoader.getImage(name, view)
        }
    }

    @BindingAdapter("loadBigImage")
    fun loadBigImage(view: ImageView, imageName: String?) {
        imageName?.let { name ->
            imageLoader.getBigImage(name, view)
        }
    }
}
