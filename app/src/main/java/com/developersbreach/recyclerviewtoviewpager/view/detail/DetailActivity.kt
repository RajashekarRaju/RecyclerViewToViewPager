package com.developersbreach.recyclerviewtoviewpager.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports

class DetailActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.title = getString(R.string.detail_title)

        val sports: Sports = intent.getParcelableExtra("Intent to Detail Activity")!!

        viewPager2 = findViewById(R.id.detail_view_pager)
        viewPager2.setPageTransformer(ZoomOutPageTransformer())

        val sportsList: List<Sports> = Sports.sportsList(applicationContext)
        val detailViewPagerAdapter = DetailViewPagerAdapter()
        detailViewPagerAdapter.submitList(sportsList)

        viewPager2.adapter = detailViewPagerAdapter
        viewPager2.setCurrentItem(sports.id, false)
    }
}