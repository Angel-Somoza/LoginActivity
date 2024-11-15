package com.example.loginactivity.Data.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Donut(
    @SerializedName("id")  val id: String,
    @SerializedName("type") val type: String,
    @SerializedName("name")   val name: String,
    @SerializedName("ppu") val ppu: Double,
    @SerializedName("batters")  val batters: Batters,
    @SerializedName("topping")  val topping: List<Topping>
): Parcelable
