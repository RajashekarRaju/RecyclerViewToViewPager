package com.developersbreach.recyclerviewtoviewpager.view.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.developersbreach.recyclerviewtoviewpager.databinding.ItemDetailAdapterBinding
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.developersbreach.recyclerviewtoviewpager.view.detail.DetailViewPagerAdapter.DetailViewHolder
import com.developersbreach.recyclerviewtoviewpager.viewModel.DetailViewModel


class DetailViewPagerAdapter(
    private val viewPager2: ViewPager2,
    private val viewModel: DetailViewModel
) :
    ListAdapter<Sports, DetailViewHolder>(DiffCallback) {


    class DetailViewHolder(
        private val binding: ItemDetailAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            sport: Sports,
            viewModel: DetailViewModel,
            viewPager: ViewPager2
        ) {
            binding.sport = sport
            binding.viewModel = viewModel
            binding.viewPager = viewPager
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val sportsArgs: Sports = getItem(position)
        holder.bind(sportsArgs, viewModel, viewPager2)
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
