package com.developersbreach.recyclerviewtoviewpager.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.developersbreach.recyclerviewtoviewpager.model.Sports

class DetailViewModel(application: Application, sports: Sports): AndroidViewModel(application) {

    private val _sportList: MutableLiveData<List<Sports>> = MutableLiveData()
    val sportList: MutableLiveData<List<Sports>>
        get() = _sportList

    private val _selectedSport: MutableLiveData<Sports> = MutableLiveData()
    val selectedSport: MutableLiveData<Sports>
        get() = _selectedSport

    init {
        val sportsList: List<Sports> = Sports.sportsList(application.applicationContext)
        _sportList.value = sportsList
        _selectedSport.value = sports
    }
}