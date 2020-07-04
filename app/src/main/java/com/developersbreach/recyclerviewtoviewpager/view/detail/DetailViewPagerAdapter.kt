package com.developersbreach.recyclerviewtoviewpager.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.developersbreach.recyclerviewtoviewpager.view.detail.DetailViewPagerAdapter.DetailViewHolder


class DetailViewPagerAdapter(
    private val sportsList: List<Sports>
) : RecyclerView.Adapter<DetailViewHolder>() {

    class DetailViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val banner: ImageView = itemView.findViewById(R.id.banner_detail_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_detail_text_view)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle_detail_text_view)
        private val about: TextView = itemView.findViewById(R.id.about_detail_text_view)

        fun bind(
            sport: Sports
        ) {
            banner.setImageResource(sport.banner)
            title.text = sport.title
            subtitle.text = sport.subtitle
            about.text = sport.about
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_detail_adapter, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val sportsArgs: Sports = sportsList[position]
        holder.bind(sportsArgs)
    }

    override fun getItemCount() = sportsList.size
}
