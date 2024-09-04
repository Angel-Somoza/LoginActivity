package com.example.loginactivity.Data.Api.Json

data class Donut(
    val id: String,
    val type: String,
    val name: String,
    val ppu: Double,
    val batters: Batters,
    val topping: List<Topping>
)
