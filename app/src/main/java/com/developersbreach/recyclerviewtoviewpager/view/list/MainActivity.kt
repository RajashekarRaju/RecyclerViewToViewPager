package com.developersbreach.recyclerviewtoviewpager.view.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.developersbreach.recyclerviewtoviewpager.view.detail.DetailActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sportsList: List<Sports> = Sports.sportsList(applicationContext)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val adapter = SportsAdapter(sportsList, sportsItemListener)
        recyclerView.adapter = adapter
    }

    private val sportsItemListener = SportsAdapter.OnClickListener { sports ->
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Intent to Detail Activity", sports)
        startActivity(intent)
    }
}
