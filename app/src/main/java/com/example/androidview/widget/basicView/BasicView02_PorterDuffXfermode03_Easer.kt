package com.example.androidview.widget.basicView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.androidview.R


class BasicView02_PorterDuffXfermode03_Easer : View {

    lateinit var mPaint: Paint
    lateinit var mDstBmp: Bitmap
    lateinit var mSrcBmp: Bitmap
    lateinit var mTxtBmp: Bitmap
    lateinit var mPath: Path

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


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(1000,500)
    }
    private fun init() {
        //初始化画笔
        mPaint = Paint()
        mPaint.color = Color.RED
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 80f
        mPaint.strokeCap = Paint.Cap.ROUND

        //禁用硬件加速
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        //初始化图片对象
        mTxtBmp = BitmapFactory.decodeResource(resources, R.drawable.result)
        mSrcBmp = BitmapFactory.decodeResource(resources, R.drawable.eraser)
        mDstBmp =
            Bitmap.createBitmap(mSrcBmp.getWidth(), mSrcBmp.getHeight(), Bitmap.Config.ARGB_8888)

        //路径（贝塞尔曲线）
        mPath = Path()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //绘制刮奖结果
        canvas.drawBitmap(mTxtBmp, 0f, 0f, mPaint)

        //使用离屏绘制
        val layerID = canvas.saveLayer(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            mPaint,
            Canvas.ALL_SAVE_FLAG
        )

        //先将路径绘制到 bitmap上
        val dstCanvas = Canvas(mDstBmp)
        dstCanvas.drawPath(mPath, mPaint)

        //绘制 目标图像
        canvas.drawBitmap(mDstBmp, 0f, 0f, mPaint)
        //设置 模式 为 SRC_OUT, 擦橡皮区域为交集区域需要清掉像素
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        //绘制源图像
        canvas.drawBitmap(mSrcBmp, 0f, 0f, mPaint)
        mPaint.xfermode = null
        canvas.restoreToCount(layerID)
    }

    private var mEventX = 0f
    private var mEventY = 0f

    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mEventX = event.x
                mEventY = event.y
                mPath.moveTo(mEventX, mEventY)
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = (event.x - mEventX) / 2 + mEventX
                val endY: Float = (event.y - mEventY) / 2 + mEventY
                //画二阶贝塞尔曲线
                mPath.quadTo(mEventX, mEventY, endX, endY)
                mEventX = event.x
                mEventY = event.y
            }
        }
        invalidate()
        return true //消费事件
    }

}