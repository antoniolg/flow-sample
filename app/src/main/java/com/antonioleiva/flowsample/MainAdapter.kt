package com.antonioleiva.flowsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antonioleiva.flowsample.databinding.ViewMainBinding
import kotlin.properties.Delegates

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var items: List<String> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewMainBinding.bind(view)

        fun bind(value: String) {
            binding.root.text = value
        }
    }
}