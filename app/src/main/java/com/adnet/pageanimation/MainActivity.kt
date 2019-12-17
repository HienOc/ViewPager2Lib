package com.adnet.pageanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)


        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val springDotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)

        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val adapter = DotIndicatorPager2Adapter()
        viewPager2.adapter = adapter

        val zoomOutPageTransformer = ZoomOutPageTransformer()
        viewPager2.setPageTransformer { page, position ->
            zoomOutPageTransformer.transformPage(page, position)
        }

        dotsIndicator.setViewPager2(viewPager2)
        springDotsIndicator.setViewPager2(viewPager2)
        wormDotsIndicator.setViewPager2(viewPager2)
    }
}
