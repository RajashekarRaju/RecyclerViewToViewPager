package com.developersbreach.recyclerviewtoviewpager.view.list

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

class SportsAdapter(
    private val sportsList: List<Sports>,
    private val onClickListener: OnClickListener
) :
    ListAdapter<Sports, SportsAdapter.SportsViewHolder>(
        DiffCallback
    ) {

    class SportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageView: ImageView = itemView.findViewById(R.id.social_item_image_view)
        val titleTextView: TextView = itemView.findViewById(R.id.title_item_text_view)
        val subtitleTextView: TextView = itemView.findViewById(R.id.subtitle_item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        return SportsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sports: Sports = sportsList[position]
        holder.iconImageView.setImageResource(sports.icon)
        holder.titleTextView.text = sports.title
        holder.subtitleTextView.text = sports.subtitle

        holder.itemView.setOnClickListener{
            onClickListener.onClick(sports)
        }
    }

    override fun getItemCount() = sportsList.size

    class OnClickListener(val clickListener: (sports: Sports) -> Unit) {
        fun onClick(sports: Sports) = clickListener(sports)
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