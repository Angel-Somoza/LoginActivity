package com.example.loginactivity.Data.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Batter(
    @SerializedName("id")val id: String,
    @SerializedName("type")  val type: String): Parcelable