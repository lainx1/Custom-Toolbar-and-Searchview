package com.example.customsearchview

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ContextThemeWrapper
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

object ActivityManager {
    fun setSupportActionBar(activity: AppCompatActivity, toolbar: Toolbar){
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.title = activity.getString(R.string.app_name)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.navigationIcon?.setColorFilter(
            AttsManager.getColor(
                activity = activity,
                resStyleable = R.styleable.ds,
                resColor = R.styleable.ds_colorInAccent,
                defaultColor = android.R.color.black),
            PorterDuff.Mode.SRC_ATOP)
    }

    fun createOptionsMenu(
        activity: AppCompatActivity,
        menu: Menu,
        resMenu: Int ,
        resMenuItems: Array<Int>,
        queryTextListener: SearchView.OnQueryTextListener,
        actionExpandListener: MenuItem.OnActionExpandListener): Menu{
        val menuInflater = activity.menuInflater
        menuInflater.inflate(resMenu, menu)

        for (resMenuItem in resMenuItems){
            val menuItem = menu.findItem(resMenuItem)
            val icon = menuItem.icon
            icon.mutate()
            icon.setColorFilter(
                AttsManager.getColor(
                    activity = activity,
                    resStyleable = R.styleable.ds,
                    resColor = R.styleable.ds_colorInAccent,
                    defaultColor = Color.BLACK
                ),
                PorterDuff.Mode.SRC_IN
            )

            when(resMenuItem){
                R.id.action_search ->{
                    val searchManager = activity.getSystemService(Context.SEARCH_SERVICE) as SearchManager
                    val searchView = SearchView(ContextThemeWrapper(activity, R.style.SearchView), null, 0)
                    searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.componentName))
                    searchView.setOnQueryTextListener(queryTextListener)
                    menuItem.setOnActionExpandListener(actionExpandListener)
                    menuItem.actionView = searchView
                }
            }
        }
        return menu
    }
}