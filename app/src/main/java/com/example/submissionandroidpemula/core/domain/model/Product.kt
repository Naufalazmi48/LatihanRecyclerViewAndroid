package com.example.submissionandroidpemula.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id:String,
    val name:String,
    val specification: String,
    val price: Int,
    val description:String,
    val stars: Float,
    val imgPath:String,
):Parcelable
