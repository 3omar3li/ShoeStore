package com.omarali.shoestore.ui.shoeslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesListViewModel : ViewModel() {
    init {
        Log.i("ShoesListViewModel", "ShoesListViewModel Created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoesListViewModel", "ShoesListViewModel Destroyed!")
    }
}