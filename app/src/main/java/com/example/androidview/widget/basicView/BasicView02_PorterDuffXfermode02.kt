package com.example.androidview.widget.basicView


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


// 一个简单的PorterDuffxMode的实现
class BasicView02_PorterDuffXfermode02 : View {
    lateinit var mPaint: Paint
    private var mWidth = 0
    private var mHeight: Int = 0


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
        //初始化画笔
        mPaint = Paint()
        mPaint.setColor(Color.RED)
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE)
        //禁止硬件加速
        //禁止硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null)


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //1.ComposeShader
        //2.画笔Paint.setXfermode()
        //3.PorterDuffColorFilter
        setBackgroundColor(Color.GRAY)

//        //离屏绘制
        val layerId =
            canvas.saveLayer(
                0f,
                0f,
                width.toFloat(),
                height.toFloat(),
                mPaint,
                Canvas.ALL_SAVE_FLAG
            );

        //目标图
        canvas.drawBitmap(createCircleBitmap(mWidth, mHeight), 0f, 0f, mPaint)
        //设置混合模式
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.XOR)
        //源图，重叠区域右下角部分
        canvas.drawBitmap(createRectBitmap(mWidth, mHeight), 0f, 0f, mPaint)
        //清除混合模式
        mPaint.xfermode = null
        canvas.restoreToCount(layerId);
    }

    //画矩形Dst
    private fun createRectBitmap(width: Int, height: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val dstPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        dstPaint.color = -0x995501
        canvas.drawRect(Rect(width / 20, height / 3, 2 * width / 3, 19 * height / 20), dstPaint)
        return bitmap
    }

    //画圆src
    private fun createCircleBitmap(width: Int, height: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val scrPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        scrPaint.color = -0x33bc
        canvas.drawCircle(
            (width * 2 / 3).toFloat(), (height / 3).toFloat(),
            (height / 4).toFloat(), scrPaint
        )
        return bitmap
    }


}
