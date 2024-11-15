package com.example.loginactivity.Data.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topping(val id: String,
                   val type: String):Parcelable