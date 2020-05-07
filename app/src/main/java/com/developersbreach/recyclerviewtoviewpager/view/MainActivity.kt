package com.developersbreach.recyclerviewtoviewpager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.developersbreach.recyclerviewtoviewpager.R

class MainActivity : AppCompatActivity() {

    private lateinit var mNavigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}
