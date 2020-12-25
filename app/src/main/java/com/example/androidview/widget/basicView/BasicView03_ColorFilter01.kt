package com.example.androidview.widget.basicView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.androidview.R


class BasicView03_ColorFilter01 : View {

    lateinit var mPaint: Paint
    lateinit var mBitmap: Bitmap

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
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.girl)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        /**
         * R' = R * mul.R / 0xff + add.R
         * G' = G * mul.G / 0xff + add.G
         * B' = B * mul.B / 0xff + add.B
         */
        //红色去除掉
//        val lighting: LightingColorFilter = LightingColorFilter(0x00ffff, 0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas?.drawBitmap(mBitmap, 0f, 0f, mPaint);

//        //原始图片效果
//        val lighting: LightingColorFilter = LightingColorFilter(0xffffff, 0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas?.drawBitmap(mBitmap, 0f, 0f, mPaint);
//
//        //绿色更亮
//        val lighting: LightingColorFilter = LightingColorFilter(0xffffff, 0x003000);
//        mPaint.setColorFilter(lighting);
//        canvas?.drawBitmap(mBitmap, 0f, 0f, mPaint);

        //让红色和bitmapm混合
//        val porterDuffColorFilter:PorterDuffColorFilter  =   PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN);
//        mPaint.setColorFilter(porterDuffColorFilter);
//        canvas.drawBitmap(mBitmap, 100f, 0f, mPaint);

//        colorMatrix:float[]  = {
//            2,0,0,0,0,   //red
//            0,1,0,0,0,   //green
//            0,0,1,0,0,   //blue
//            0,0,0,1,0    //alpha
//        };

//  可以使用ColorMatrix来配置
        val cm: ColorMatrix = ColorMatrix();
//        //亮度调节
        cm.setScale(1f, 2f, 1f, 1f);

//        //饱和度调节0-无色彩， 1- 默认效果， >1饱和度加强
        cm.setSaturation(2f);

        //色调调节
        cm.setRotate(0, 45f);
//        cm.setConcat();
//        val mColorMatrixColorFilter: ColorMatrixColorFilter = ColorMatrixColorFilter(cm);
        val mColorMatrixColorFilter: ColorMatrixColorFilter = ColorMatrixColorFilter(colormatrix_fanse);
        mPaint.colorFilter = mColorMatrixColorFilter;
        canvas.drawBitmap(mBitmap, 0f, 0f, mPaint);
    }

    // 胶片，使用数组的形式来配置。
    val colormatrix_fanse = floatArrayOf(
        -1.0f, 0.0f, 0.0f, 0.0f, 255.0f,
        0.0f, -1.0f, 0.0f, 0.0f, 255.0f,
        0.0f, 0.0f, -1.0f, 0.0f, 255.0f,
        0.0f, 0.0f, 0.0f, 1.0f, 0.0f
    )

}