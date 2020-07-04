package com.developersbreach.recyclerviewtoviewpager.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports

class SportsAdapter(
    private val sportsList: List<Sports>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {

    class SportsViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val banner: ImageView = itemView.findViewById(R.id.banner_item_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_item_text_view)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle_item_text_view)

        fun bind(
            sports: Sports,
            onClickListener: OnClickListener
        ) {
            banner.setImageResource(sports.banner)
            title.text = sports.title
            subtitle.text = sports.subtitle
            itemView.setOnClickListener {
                onClickListener.onClick(sports)
            }
        }
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
        holder.bind(sports, onClickListener)
    }

    override fun getItemCount() = sportsList.size

    class OnClickListener(val clickListener: (sports: Sports) -> Unit) {
        fun onClick(sports: Sports) = clickListener(sports)
    }
}