package com.example.androidview.widget.basicView

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.example.androidview.R


class BasicView06_PathMeasure : View {
    lateinit var mLinePaint: Paint   //坐标系

    lateinit var bitmap: Bitmap
    lateinit var mPaint: Paint

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init()

    }


    private fun init() {
        //初始化画笔
        mPaint = Paint()
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLUE
        mPaint.strokeWidth = 8f
        mLinePaint = Paint()
        mLinePaint.style = Paint.Style.STROKE
        mLinePaint.color = Color.RED
        mLinePaint.strokeWidth = 6f

        //缩小图片
        val options = BitmapFactory.Options()
        options.inSampleSize = 3
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.arrow, options)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, 1000000)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //绘制坐标轴
//        canvas!!.drawLine(0f, height / 2.toFloat(), width.toFloat(), height / 2.toFloat(), mLinePaint)
//        canvas.drawLine(width / 2.toFloat(), 0f, width / 2.toFloat(), height.toFloat(), mLinePaint)
//        //移动原点到中心位置
//        canvas.translate(width / 2.toFloat(), height / 2.toFloat())

        canvas!!.translate(100f, 100f)
        canvas.save()
        val path = Path()
        path.lineTo(200f, 0f)
        path.lineTo(200f, 200f)
        path.lineTo(0f, 200f)
        canvas.drawPath(path, mPaint)
        canvas.restore()
        canvas.translate(0f, 1600f)//移动了一下


    }
}

