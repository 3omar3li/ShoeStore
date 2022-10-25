package com.omarali.shoestore.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.omarali.shoestore.model.SharedPreference

class LoginViewModel: ViewModel() {

    init {
        Log.i("LoginViewModel", "LoginViewModel Created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("LoginViewModel", "LoginViewModel Destroyed!")
    }
}