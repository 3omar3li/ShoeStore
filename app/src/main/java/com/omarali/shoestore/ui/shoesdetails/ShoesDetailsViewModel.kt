package com.omarali.shoestore.ui.shoesdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omarali.shoestore.model.ShoeDetails

class ShoesDetailsViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<ShoeDetails>>()
    val shoeList: LiveData<List<ShoeDetails>>
        get() = _shoeList

    fun addShoe(newShoe: ShoeDetails) {
        val value = _shoeList.value ?: listOf()
        _shoeList.value = value.plus(newShoe).toMutableList()
    }
}