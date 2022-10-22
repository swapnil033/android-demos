package com.example.myandroiddemos.data.model.artist


import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val results: List<Artist>
)