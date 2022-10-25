package com.omarali.shoestore.model

import android.content.Context
import android.content.SharedPreferences

class SharedPreference constructor(context: Context) {

    private val prefName = "ShoesPreference"
    private var preference: SharedPreferences

    init {
        preference = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    private fun putBoolean(key: String, value: Boolean){
        preference.edit().putBoolean(key, value).apply()
    }

    private fun getBoolean(key: String): Boolean {
        return preference.getBoolean(key, false)
    }

    fun login(){
        putBoolean("login", true)
    }

    fun logout(){
        putBoolean("login", false)
    }

    fun isLogin(): Boolean {
        return getBoolean("login")
    }
}