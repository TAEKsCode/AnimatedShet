package com.example.animatedshet.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private lateinit var model: MainModel

    init {
        loadInfo()
    }

    private fun loadInfo() {
        viewModelScope.launch {
            //if (no model in prefs)
            model = MainModel("sanya", "40rt")
        }
    }
}