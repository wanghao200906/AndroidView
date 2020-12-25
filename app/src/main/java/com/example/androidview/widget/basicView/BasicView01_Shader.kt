package com.example.androidview.widget.basicView


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.androidview.R

class BasicView01_Shader : View {
    lateinit var mShader: LinearGradient
    lateinit var mShader2: RadialGradient
    lateinit var mShader3: SweepGradient
    lateinit var mShader4: BitmapShader
    lateinit var mShader5: ComposeShader
    lateinit var mPaint: Paint
    var x1: Float = 0f
    var y1: Float = 0f
    var margin: Float = 50f
    var mWidth: Float = 500f

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
        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, 10000)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var mBitmap3 = BitmapFactory.decodeResource(resources, R.drawable.demo);


        /**
         * 1.线性渲染,LinearGradient(float x0, float y0, float x1, float y1, @NonNull @ColorInt int colors[], @Nullable float positions[], @NonNull TileMode tile)
         * (x0,y0)：渐变起始点坐标
         * (x1,y1):渐变结束点坐标
         * color0:渐变开始点颜色,16进制的颜色表示，必须要带有透明度
         * color1:渐变结束颜色
         * colors:渐变数组
         * positions:位置数组，position的取值范围[0,1],作用是指定某个位置的颜色值，如果传null，渐变就线性变化。
         * tile:用于指定控件区域大于指定的渐变区域时，空白区域的颜色填充方法
         */

        mShader = LinearGradient(
            0f,
            y1+0f,
            500f,
            y1+500f,
            intArrayOf(Color.RED, Color.BLUE),
            floatArrayOf(0f, 1f),
            Shader.TileMode.REPEAT
        )
        mPaint.shader = mShader
        canvas?.drawCircle(250f, y1+250f, 250f, mPaint)
        y1 += mWidth + margin
        canvas?.drawRect(0f, y1, 1000f, y1 + mWidth, mPaint)
        y1 += mWidth + margin

        /**
         * 环形渲染，
         * RadialGradient(float centerX, float centerY, float radius, @ColorInt int colors[], @Nullable float stops[], TileMode tileMode)
         * centerX ,centerY：shader的中心坐标，开始渐变的坐标
         * radius:渐变的半径
         * centerColor,edgeColor:中心点渐变颜色，边界的渐变颜色
         * colors:渐变颜色数组
         * stops:渐变位置数组，类似扫描渐变的positions数组，取值[0,1],中心点为0，半径到达位置为1.0f
         * tileMode:shader未覆盖以外的填充模式。
         */
        mShader2 = RadialGradient(
            250f,
            y1 + 250f,
            250f,
            intArrayOf(Color.RED, Color.BLUE, Color.YELLOW),
            null,
            Shader.TileMode.REPEAT
        );
        mPaint.shader = mShader2;
        canvas?.drawCircle(250f, y1 + 250f, 250f, mPaint);
        y1 += mWidth + margin
        canvas?.drawRect(0f, y1, 1000f, y1 + mWidth, mPaint)
        y1 += mWidth + margin

        /**
         * 扫描渲染，SweepGradient(float cx, float cy, @ColorInt int color0,int color1)
         * cx,cy 渐变中心坐标
         * color0,color1：渐变开始结束颜色
         * colors，positions：类似LinearGradient,用于多颜色渐变,positions为null时，根据颜色线性渐变
         */

        mPaint.reset()
        mShader3 = SweepGradient(250f, y1 + 250f, Color.RED, Color.GREEN)
        mPaint.shader = mShader3
        canvas?.drawCircle(250f, y1 + 250f, 250f, mPaint)
        y1 += mWidth + margin


        /**
         * 位图渲染，BitmapShader(@NonNull Bitmap bitmap, @NonNull TileMode tileX, @NonNull TileMode tileY)
         * Bitmap:构造shader使用的bitmap
         * tileX：X轴方向的TileMode
         * tileY:Y轴方向的TileMode
        REPEAT, 绘制区域超过渲染区域的部分，重复排版
        CLAMP， 绘制区域超过渲染区域的部分，会以最后一个像素拉伸排版
        MIRROR, 绘制区域超过渲染区域的部分，镜像翻转排版
         */
        canvas?.save()
        canvas?.translate(0f,y1)

        mShader4 = BitmapShader(mBitmap3, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mPaint.shader = mShader4
        canvas?.drawRect(0f, 0f, 500f, 500f, mPaint)
        canvas?.restore()
        y1 += mWidth + margin

        /**
         * 组合渲染，
         * ComposeShader(@NonNull Shader shaderA, @NonNull Shader shaderB, Xfermode mode)
         * ComposeShader(@NonNull Shader shaderA, @NonNull Shader shaderB, PorterDuff.Mode mode)
         * shaderA,shaderB:要混合的两种shader
         * Xfermode mode： 组合两种shader颜色的模式
         * PorterDuff.Mode mode: 组合两种shader颜色的模式
         */
        canvas?.save()
        canvas?.translate(0f,y1)

        val bitmapShader = BitmapShader(mBitmap3, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        val linearGradient = LinearGradient(
            0f,
            0f,
            500f,
            500f,
            intArrayOf(Color.RED, Color.YELLOW),
            null,
            Shader.TileMode.REPEAT
        );
        mShader5 = ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        mPaint.shader = mShader5;
        canvas?.drawCircle(250f, 250f, 250f, mPaint);
        canvas?.restore()
    }
}