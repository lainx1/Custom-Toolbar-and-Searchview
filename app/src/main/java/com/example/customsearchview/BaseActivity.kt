package com.example.customsearchview

import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate

open class BaseActivity: AppCompatActivity() {
    init {
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}