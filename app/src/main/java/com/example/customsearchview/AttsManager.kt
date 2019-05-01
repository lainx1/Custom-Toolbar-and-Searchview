package com.example.customsearchview

import android.support.v7.app.AppCompatActivity

object AttsManager{
    fun getColor(activity: AppCompatActivity, resStyleable: IntArray, resColor: Int, defaultColor: Int): Int{
        if (resColor < 0) return defaultColor
        val typedArray = activity.obtainStyledAttributes(resStyleable)
        return  typedArray.getColor(resColor, defaultColor)
    }
}