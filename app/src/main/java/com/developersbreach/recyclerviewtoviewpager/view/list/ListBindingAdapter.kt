package com.developersbreach.recyclerviewtoviewpager.view.list

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.google.android.material.card.MaterialCardView


@BindingAdapter("bindListData")
fun RecyclerView.setListData(sportsList: List<Sports>) {

    let { recyclerView ->

        val adapter = SportsAdapter()
        adapter.submitList(sportsList)
        recyclerView.adapter = adapter

        RecyclerViewItemDecoration.setItemSpacing(
            resources, recyclerView
        )
    }
}


@BindingAdapter("bindSportImageItem")
fun ImageView.setSportItemImage(sports: Sports) {
    this.setImageResource(sports.icon)
}


@BindingAdapter("bindItemClickListener")
fun MaterialCardView.setItemClickListener(sports: Sports) {

    let { cardView ->
        cardView.setOnClickListener { view ->
            val direction: NavDirections =
                ListFragmentDirections.actionListFragmentToDetailFragment(sports)
            Navigation.findNavController(view).navigate(direction)
        }
    }
}