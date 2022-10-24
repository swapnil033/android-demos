package com.example.myandroiddemos.presentation.artist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myandroiddemos.data.model.artist.Artist
import com.example.myandroiddemos.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {

    private var artistList = ArrayList<Artist>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(artists : List<Artist>){
        artistList.clear()
        artistList = ArrayList(artists)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ArtistViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(artist: Artist){
        binding.titleTextView.text = artist.name
        val imagePath = "https://image.tmdb.org/t/p/w500" + artist.profilePath

        Glide.with(binding.imageView.context)
            .load(imagePath)
            .into(binding.imageView)
    }

}