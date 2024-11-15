package com.example.loginactivity.Data.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batters(
    val batter: List<Batter>

):Parcelable
