package com.example.customsearchview

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    private fun initListeners(){
        btnSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }
}
