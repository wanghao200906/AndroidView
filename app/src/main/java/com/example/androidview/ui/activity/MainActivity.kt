package com.example.androidview.ui.activity

import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.androidview.R
import com.example.androidview.ui.fragment.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
//        capp://hcpay-super-limit-aul?PARAM_SCREEN_TYPE=screenType
        val uri = Uri.Builder().scheme("capp").authority("dd-for-lib").appendQueryParameter("PARAM_SCREEN_TYPE", "screenType").build()
        println(uri.toString())

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    private fun initFragment() {
        supportFragmentManager.commit {
            addToBackStack(MainFragment::class.java.canonicalName)
            replace<MainFragment>(R.id.container)
        }
    }
}