package com.example.myandroiddemos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroiddemos.databinding.RowSubscriberBinding
import com.example.myandroiddemos.db.Subscriber
import com.example.myandroiddemos.generated.callback.OnClickListener

class SubscriberAdapter(
    private val subscribersList : List<Subscriber>,
    private val clickListener: (Subscriber) -> Unit
    ) : RecyclerView.Adapter<SubscriberHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberHolder {
        val binding = RowSubscriberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubscriberHolder(binding)
    }

    override fun onBindViewHolder(holder: SubscriberHolder, position: Int) {
        holder.binding.model = subscribersList[position]
        holder.itemView.setOnClickListener {
            clickListener(subscribersList[position])
        }
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }
}

class SubscriberHolder(binding : RowSubscriberBinding) : RecyclerView.ViewHolder(binding.root) {
    val binding : RowSubscriberBinding
    init {
        this.binding = binding
    }
}