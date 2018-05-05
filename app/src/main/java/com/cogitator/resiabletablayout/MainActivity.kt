package com.cogitator.resiabletablayout

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.cogitator.resizabletabs.ResizableTabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewpager = findViewById<ViewPager>(R.id.viewpager)
        val atl = findViewById<ResizableTabLayout>(R.id.rtl)

        val adapter = PagerAdapter(supportFragmentManager)
        viewpager.adapter = adapter
        atl.setupViewPager(viewpager)
        atl.setTabChangeListener(object : ResizableTabLayout.OnChangeListener {
            override fun onChanged(position: Int) {
            }
        })
    }
}
