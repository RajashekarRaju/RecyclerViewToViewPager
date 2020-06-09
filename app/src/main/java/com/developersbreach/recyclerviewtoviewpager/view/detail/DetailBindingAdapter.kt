package com.developersbreach.recyclerviewtoviewpager.view.detail

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.developersbreach.recyclerviewtoviewpager.viewModel.DetailViewModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton


@BindingAdapter("bindDetailViewModel")
fun ViewPager2.setDetailViewPager(
    viewModel: DetailViewModel
) {
    val detailViewPagerAdapter = DetailViewPagerAdapter(this, viewModel)
    detailViewPagerAdapter.submitList(viewModel.sportList)
    this.adapter = detailViewPagerAdapter
    this.setCurrentItem(viewModel.selectedSport.id, false)
}


@BindingAdapter("bindDetailItemImage")
fun ImageView.setDetailItemImage(sports: Sports) {
    this.setImageResource(sports.icon)
}


@BindingAdapter("bindViewPager", "bindViewPagerFab")
fun Toolbar.setToolbar(
    viewPager: ViewPager2,
    viewPagerFab: FloatingActionButton
) {
    val toolbar: Toolbar = this
    toolbar.setNavigationOnClickListener { view ->
        Navigation.findNavController(view).navigateUp()
    }

    viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)

            when (state) {
                ViewPager2.SCROLL_STATE_DRAGGING -> {
                    toolbar.navigationIcon = null
                    viewPagerFab.visibility = View.INVISIBLE
                }
                ViewPager2.SCROLL_STATE_IDLE -> {
                    toolbar.setNavigationIcon(R.drawable.ic_up_button)
                    viewPagerFab.visibility = View.VISIBLE
                }
                ViewPager2.SCROLL_STATE_SETTLING -> {
                    toolbar.navigationIcon = null
                    viewPagerFab.visibility = View.INVISIBLE
                }
            }
        }
    })
}


@BindingAdapter("bindDetailAppbar", "bindDetailCollapsingToolbar")
fun AppBarLayout.setDetailAppbar(
    sports: Sports,
    collapsingToolbar: CollapsingToolbarLayout
) {
    this.addOnOffsetChangedListener(
        appBarLayoutListener(sports, collapsingToolbar)
    )
}

private fun appBarLayoutListener(
    sportsArgs: Sports,
    collapsingToolbar: CollapsingToolbarLayout
): AppBarLayout.OnOffsetChangedListener {

    return object : AppBarLayout.OnOffsetChangedListener {
        var isShow = false
        var scrollRange = -1
        override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
            if (scrollRange == -1) {
                scrollRange = appBarLayout.totalScrollRange
            }
            if (scrollRange + verticalOffset == 0) {
                // Show title when completely collapsed.
                collapsingToolbar.title = sportsArgs.title
                isShow = true
            } else if (isShow) {
                // Hide title when collapsedToolBar is completely visible using empty string.
                collapsingToolbar.title = ""
                isShow = false
            }
        }
    }
}