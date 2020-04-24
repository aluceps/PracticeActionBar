package com.example.practiceactionbar

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.practiceactionbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.toolbar.addMarginStatusBarHeight()

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "example for actionbar"
        }
    }
}

fun Toolbar.addMarginStatusBarHeight() {
    resources.getIdentifier("status_bar_height", "dimen", "android").let { id ->
        if (id > 0) {
            val height = resources.getDimensionPixelSize(id)
            (layoutParams as ViewGroup.MarginLayoutParams).topMargin = height
        }
    }
}