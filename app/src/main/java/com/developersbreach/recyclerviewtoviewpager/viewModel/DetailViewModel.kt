package com.developersbreach.recyclerviewtoviewpager.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.developersbreach.recyclerviewtoviewpager.model.Sports

class DetailViewModel(application: Application, sports: Sports): AndroidViewModel(application) {

    private val _sportList = Sports.sportsList(application.applicationContext)
    val sportList: List<Sports>
        get() = _sportList

    private val _selectedSport = sports
    val selectedSport: Sports
        get() = _selectedSport
}