package com.example.myandroiddemos.presentation.tvShow

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myandroiddemos.data.model.tvShow.Tv
import com.example.myandroiddemos.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {

    private var tvShowList = ArrayList<Tv>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(tvShows : List<Tv>){
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class TvShowViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow : Tv){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val imagePath = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath

        Glide.with(binding.imageView.context)
            .load(imagePath)
            .into(binding.imageView)
    }

}