package com.example.customsearchview

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.view.ContextThemeWrapper
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar.*

class SearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        ActivityManager.setSupportActionBar(activity = this, toolbar = toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(
            ActivityManager.createOptionsMenu(
                activity = this,
                resMenu = R.menu.search_option,
                menu = menu!!,
                resMenuItems = arrayOf(R.id.action_search),
                queryTextListener = object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(text: String?): Boolean {
                        Log.d(javaClass.simpleName, "Submit: $text")
                        return false
                    }

                    override fun onQueryTextChange(text: String?): Boolean {
                        Log.d(javaClass.simpleName, "Change: $text")
                        return false
                    }
                },
                actionExpandListener = object : MenuItem.OnActionExpandListener{
                    override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                        toolbar.setBackgroundColor(ContextCompat.getColor(this@SearchActivity, android.R.color.white))
                        toolbar.navigationIcon?.setColorFilter(
                            AttsManager.getColor(
                                activity = this@SearchActivity,
                                resStyleable = R.styleable.ds,
                                resColor =  -1,
                                defaultColor = android.R.color.black),
                            PorterDuff.Mode.SRC_ATOP)
                        return true
                    }

                    override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                        toolbar.setBackgroundColor(ContextCompat.getColor(this@SearchActivity, R.color.colorAccent))
                        toolbar.navigationIcon?.setColorFilter(
                            AttsManager.getColor(
                                activity = this@SearchActivity,
                                resStyleable = R.styleable.ds,
                                resColor = R.styleable.ds_colorInAccent,
                                defaultColor = android.R.color.black),
                            PorterDuff.Mode.SRC_ATOP)
                        return true
                    }

                }
            )
        )
    }
}
