package com.developersbreach.recyclerviewtoviewpager.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.developersbreach.recyclerviewtoviewpager.model.Sports

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val _sports: MutableLiveData<List<Sports>> = MutableLiveData()
    val sports: LiveData<List<Sports>>
        get() = _sports

    init {
        val sportsList: List<Sports> = Sports.sportsList(application.applicationContext)
        _sports.value = sportsList
    }
}