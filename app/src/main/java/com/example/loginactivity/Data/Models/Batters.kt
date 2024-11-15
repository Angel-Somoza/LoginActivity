package com.example.loginactivity.Data.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Batters(
    @SerializedName("batter") val batter: List<Batter>

):Parcelable
