package com.example.androidview.widget.basicView

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class MyViewMeasure : ViewGroup {
//    想用Thread.dumpStack()看一下为什么onMeasure调用了两次。但是也没看出来
    private   val TAG = "MyViewMeasure"
    constructor(mContext: Context) : super(mContext) {
        val context = mContext
    }

    constructor(mContext: Context, mAttributeSet: AttributeSet) : super(mContext, mAttributeSet) {
        val context = mContext
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        parent.requestDisallowInterceptTouchEvent(true)
        return super.onTouchEvent(event)
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d(TAG, "onMeasure: ------------------------")
        Thread.dumpStack()
        Log.d(TAG, "onMeasure: ------------------------")

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val childAt = getChildAt(0)
        Log.d(TAG, "onLayout: ------------------------")
        Thread.dumpStack()
        Log.d(TAG, "onLayout: ------------------------")
    }


}