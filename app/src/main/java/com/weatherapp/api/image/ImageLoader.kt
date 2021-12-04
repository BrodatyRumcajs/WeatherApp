package com.weatherapp.api.image

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.weatherapp.api.config.ApiConfig
import javax.inject.Inject
import javax.inject.Singleton

private const val NORMAL_IMAGE = "@2x.png"
private const val BIG_IMAGE = "@4x.png"

@Singleton
class ImageLoader @Inject constructor(
    private val picasso: Picasso,
    private val apiConfig: ApiConfig
) {

    fun getImage(imageName: String, imageView: ImageView) {
        picasso.load(getImageUrl(imageName, false)).into(imageView)
    }

    fun getBigImage(imageName: String, imageView: ImageView) {
        picasso.load(getImageUrl(imageName, true)).into(imageView)
    }

    private fun getImageUrl(imageName: String, big: Boolean): String =
        StringBuilder(apiConfig.getImagesBaseUrl())
            .append(imageName)
            .append(getImageType(big))
            .toString()

    private fun getImageType(big: Boolean): String = when (big) {
        true -> BIG_IMAGE
        else -> NORMAL_IMAGE
    }
}
