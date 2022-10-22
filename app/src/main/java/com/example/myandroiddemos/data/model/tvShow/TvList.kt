package com.example.myandroiddemos.data.model.tvShow


import com.google.gson.annotations.SerializedName

data class TvList(
    @SerializedName("results")
    val tvs: List<Tv>
)