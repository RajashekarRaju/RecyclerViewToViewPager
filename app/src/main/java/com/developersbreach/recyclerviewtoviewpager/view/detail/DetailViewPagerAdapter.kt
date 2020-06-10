package com.developersbreach.recyclerviewtoviewpager.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.developersbreach.recyclerviewtoviewpager.view.detail.DetailViewPagerAdapter.DetailViewHolder


class DetailViewPagerAdapter : ListAdapter<Sports, DetailViewHolder>(DiffCallback) {

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = itemView.findViewById(R.id.detail_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_detail_text_view)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle_detail_text_view)
        private val about: TextView = itemView.findViewById(R.id.about_detail_text_view)

        fun bind(sportsArgs: Sports) {
            icon.setImageResource(sportsArgs.icon)
            title.text = sportsArgs.title
            subtitle.text = sportsArgs.subtitle
            about.text = sportsArgs.about
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_detail_adapter, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val sportsArgs: Sports = getItem(position)
        holder.bind(sportsArgs)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Sports>() {
        override fun areItemsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem.title == newItem.title
        }
    }
}
