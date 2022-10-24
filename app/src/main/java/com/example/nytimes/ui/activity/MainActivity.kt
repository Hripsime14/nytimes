package com.example.nytimes.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytimes.R
import com.example.nytimes.ui.common.BaseActivity
import com.example.nytimes.ui.feature.MostPopularArticlesFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }

    private fun createFragment() {
        supportFragmentManager.
            beginTransaction().
            addToBackStack(null).
            replace(R.id.fcv, MostPopularArticlesFragment.newInstance(), null).
            commit()
    }
}