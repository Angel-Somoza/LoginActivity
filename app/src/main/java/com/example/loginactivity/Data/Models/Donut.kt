package com.example.loginactivity.Data.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Donut(
    val id: String,
    val type: String,
    val name: String,
    val ppu: Double,
    val batters: Batters,
    val topping: List<Topping>
): Parcelable
