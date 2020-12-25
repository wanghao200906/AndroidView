package com.example.androidview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidview.R
import com.example.androidview.databinding.CoolViewSplashBinding

class Cool04ViewXiaoHongShuSplashFragment : Fragment() {
    private lateinit var binding: CoolViewSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.cool_view_splash, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivMan.setBackgroundResource(R.drawable.man_run)

        binding.parallaxContainer.setUp(
            R.layout.view_intro_1,
            R.layout.view_intro_2,
            R.layout.view_intro_3,
            R.layout.view_intro_4,
            R.layout.view_intro_5,
            R.layout.view_intro_6,
            R.layout.view_intro_7,
            R.layout.view_login
        )
        binding.parallaxContainer.setIv_man(binding.ivMan)

//        val container = findViewById<View>(R.id.parallax_container) as ParallaxContainer
//        container.setUp(
//            *intArrayOf(
//                R.layout.view_intro_1,
//                R.layout.view_intro_2,
//                R.layout.view_intro_3,
//                R.layout.view_intro_4,
//                R.layout.view_intro_5,
//                R.layout.view_intro_6,
//                R.layout.view_intro_7,
//                R.layout.view_login
//            )
//        )
//        val iv_man = findViewById<View>(R.id.iv_man) as ImageView
//        iv_man.setBackgroundResource(R.drawable.man_run)
//        container.setIv_man(iv_man)

    }
}
