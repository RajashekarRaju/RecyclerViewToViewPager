package com.developersbreach.recyclerviewtoviewpager.view.list

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.recyclerviewtoviewpager.R

class RecyclerViewItemDecoration(spacingInPixels: Int) : RecyclerView.ItemDecoration() {

    private var mItemOffset = spacingInPixels

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect[mItemOffset, mItemOffset, mItemOffset] = mItemOffset
    }

    companion object {

        fun setItemSpacing(
            resources: Resources,
            recyclerView: RecyclerView
        ) {
            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.recycler_view_spacing_dimen)
            recyclerView.addItemDecoration(
                RecyclerViewItemDecoration(
                    spacingInPixels
                )
            )
        }
    }
}