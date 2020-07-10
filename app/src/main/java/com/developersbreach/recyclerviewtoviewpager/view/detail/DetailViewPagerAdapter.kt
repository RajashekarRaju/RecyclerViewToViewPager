package com.developersbreach.recyclerviewtoviewpager.view.detail

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.*
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.developersbreach.recyclerviewtoviewpager.view.detail.DetailViewPagerAdapter.DetailViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailViewPagerAdapter(
    private val sportsList: List<Sports>,
    private val activity: Activity,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<DetailViewHolder>() {

    class DetailViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val toolbar: Toolbar = itemView.findViewById(R.id.detail_toolbar)
        val fab: FloatingActionButton = itemView.findViewById(R.id.fab_detail)
        private val banner: ImageView = itemView.findViewById(R.id.detail_image_view)
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
            toolbar.title = sport.title
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

        holder.toolbar.setNavigationOnClickListener {
            activity.finish()
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                when (state) {
                    SCROLL_STATE_DRAGGING -> {
                        holder.toolbar.navigationIcon = null
                        holder.fab.visibility = View.INVISIBLE
                    }
                    SCROLL_STATE_IDLE -> {
                        holder.toolbar.setNavigationIcon(R.drawable.ic_up_button)
                        holder.fab.visibility = View.VISIBLE
                    }
                    SCROLL_STATE_SETTLING -> {
                        holder.toolbar.navigationIcon = null
                        holder.fab.visibility = View.INVISIBLE
                    }
                }
            }
        })
    }

    override fun getItemCount() = sportsList.size
}
