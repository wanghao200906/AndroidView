package com.example.androidview.widget.basicView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi


class BasicView04_TransformView : View {

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
        mPaint.color = Color.RED
        mPaint.strokeWidth = 8f
        mPaint.style = Paint.Style.STROKE
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, 1000000)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        6、矩阵 矩阵的方法setTranslate，setScale可以用来替代canvas的setScale，setTranslate等。用哪个都行
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.textSize = 100f
        canvas.drawText("Matrix的用法", 10f, 100f, mPaint)
        canvas.drawRect(300f, 300f, 600f, 600f, mPaint);
        var matrix: Matrix = Matrix();
//        matrix.setTranslate(50f, 50f); //移动
//        matrix.setRotate(45f, 450f, 450f);//旋转
        matrix.setScale(0.5f, 0.5f, 200f, 200f);//缩放
        canvas.setMatrix(matrix);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(300f, 300f, 600f, 600f, mPaint);
        canvas.restore()


        canvas.translate(0f, 800f)//移动了一下


        //1、平移操作
        canvas.save()
        mPaint.textSize = 100f
        canvas.drawText("translate用法", 600f, 200f, mPaint)
        mPaint.color = Color.RED
        canvas.drawRect(0f, 0f, 400f, 400f, mPaint)
        canvas.translate(50f, 50f)//移动了一下
        mPaint.color = Color.BLUE
        canvas.drawRect(0f, 0f, 400f, 400f, mPaint)
        canvas.drawLine(0f, 0f, 600f, 600f, mPaint)
        canvas.restore()


        canvas.translate(0f, 600f)//移动了一下


        //2、缩放操作 1
        canvas.save()
        mPaint.textSize = 100f
        canvas.drawText("scale用法", 600f, 200f, mPaint)
        canvas.drawRect(200f, 200f, 700f, 700f, mPaint)
        canvas.scale(0.5f, 0.5f) //这个缩放是让真个画布缩小为原来的0.5倍。所以位置也移动了。
        mPaint.color = Color.GRAY;
        canvas.drawRect(200f, 200f, 700f, 700f, mPaint);
        canvas.restore()

        canvas.translate(0f, 600f)//移动了一下

        //2、缩放操作 2
        canvas.save()
        mPaint.color = Color.BLUE;
        canvas.drawRect(200f, 200f, 700f, 700f, mPaint)
        //先translate(px, py),再scale(sx, sy),再反向translate
        canvas.scale(0.5f, 0.5f, 200f, 200f)
//        等价于下面这是三句话
//
//        canvas.translate(200f, 200f);
//        canvas.scale(0.5f, 0.5f);
//        canvas.translate(-200f, -200f);

        mPaint.color = Color.GRAY;
        canvas.drawRect(200f, 200f, 700f, 700f, mPaint);
        canvas.restore()


        canvas.translate(0f, 1000f)//移动了一下

        //3、旋转操作
        canvas.save()
        mPaint.textSize = 100f
        canvas.drawText("rotate用法", 600f, 200f, mPaint)
        canvas.translate(50f, 50f)//移动了一下

        mPaint.color = Color.GRAY;
        canvas.drawRect(0f, 0f, 800f, 600f, mPaint);
//        canvas.rotate(45f); //先旋转画布，以0，0位原点顺时针转45度。
        canvas.rotate(30f, 450f, 450f);//先旋转画布，以450f，450f位原点顺时针转30度。 px,py表示旋转中心
        mPaint.color = Color.BLUE;
        canvas.drawRect(0f, 0f, 800f, 600f, mPaint);
        canvas.restore()

        canvas.translate(0f, 1000f)//移动了一下


//        //4、倾斜操作
        canvas.save()
        mPaint.textSize = 100f
        canvas.drawText("skew用法", 600f, 200f, mPaint)
        mPaint.setColor(Color.RED);
        canvas.drawRect(0f, 0f, 300f, 300f, mPaint);
//        canvas.skew(1,0);//在X方向倾斜45度,Y轴逆时针旋转45
        canvas.skew(0f, 1f);//在Y方向倾斜45度,X轴顺时针旋转45
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0f, 0f, 300f, 300f, mPaint);
        canvas.restore()

        canvas.translate(0f, 1000f)//移动了一下


//        5、切割操作1
        canvas.save()
        mPaint.setColor(Color.BLUE);
        mPaint.textSize = 100f
        canvas.translate(0f, 200f)//移动了一下 为了好看
        canvas.drawText("clipRect的用法", 10f, 200f, mPaint)
        canvas.drawRect(200f, 200f, 700f, 700f, mPaint);
        mPaint.color = Color.GRAY;
        canvas.drawRect(200f, 800f, 700f, 1300f, mPaint);//画布被裁剪
        canvas.clipRect(200f, 200f, 700f, 700f); //超出画布区域的无法绘制，画布内的可以正常绘制
        mPaint.color = Color.GREEN
        canvas.drawCircle(200f, 200f, 200f, mPaint);//一部分在区域内，所以只能看到一部分
        canvas.drawCircle(400f, 600f, 100f, mPaint);//整个圆都在区域内，所以都可以展示
        canvas.restore()
        canvas.translate(0f, 1800f)//移动了一下 为了好看

//        5、切割操作2

        canvas.save()
        mPaint.setColor(Color.BLUE);
        mPaint.textSize = 100f
        canvas.drawText("clipOutRect的用法", 10f, 100f, mPaint)
        canvas.translate(0f, 200f)//移动了一下 为了好看
        canvas.drawRect(200f, 200f, 700f, 700f, mPaint);
        mPaint.color = Color.GRAY;
        canvas.drawRect(200f, 800f, 700f, 1300f, mPaint);//画布被裁剪
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            canvas.clipOutRect(200f, 200f, 700f, 700f)
        }; //超出画布区域的无法绘制，画布内的可以正常绘制
        mPaint.color = Color.GREEN
        canvas.drawCircle(200f, 200f, 200f, mPaint);//一部分在区域内，所以只能看到一部分
        canvas.drawCircle(400f, 600f, 100f, mPaint);//整个圆都在区域内，所以都可以展示
        canvas.restore()

        canvas.translate(0f, 1800f)//移动了一下 为了好看

//        7、保存/恢复
        mPaint.color = Color.GRAY
//        canvas.drawLine(0f, 300f, width.toFloat(), 300f,mPaint)//画一条横线
        Log.e("TAG", "count :" + canvas.getSaveCount());//默认counte就是1
        canvas.drawRect(200f, 300f, 700f, 700f, mPaint);//绘制第一个方块
        canvas.save();//保存
        Log.e("TAG", "count :" + canvas.getSaveCount());//如果有一次save了那么count就加1操作
        canvas.translate(50f, 50f);
        mPaint.color = Color.RED
        canvas.drawRect(0f, 0f, 500f, 500f, mPaint);//绘制第一个方块
        canvas.save()//保存
        Log.e("TAG", "count :" + canvas.getSaveCount());//如果有一次save了那么count就加1操作
        canvas.translate(50f, 50f);
        mPaint.color = Color.BLUE
        canvas.drawRect(0f, 0f, 500f, 500f, mPaint);//绘制第一个方块
        canvas.restore()
        Log.e("TAG", "count :" + canvas.getSaveCount());//如果有一次restore了那么count就减1操作
        canvas.restore()
//        canvas.restore()//如果多restore一次，那么久会报错。
        Log.e("TAG", "count :" + canvas.getSaveCount());//如果有一次restore了那么count就减1操作
        canvas.drawLine(0f, 0f, 400f, 500f, mPaint)
//      每次save都是一个压栈操作。每次一个restore都是一个出栈操作。
//      如果save了五次，想一次性的出栈  canvas.restoreToCount() 方法。里面传入的是某一次save返回的值。

        canvas.translate(0f, 1600f)//移动了一下 为了好看


//        7.1保存/恢复 离屏绘制
        mPaint.setColor(Color.RED);
        canvas.drawRect(200f, 200f, 700f, 700f, mPaint); //绘制矩形1，
        var saveLayer: Int = canvas.saveLayer(0f, 0f, 700f, 700f, mPaint)//创建了一个画布，大小和矩形1是一样的。
        mPaint.setColor(Color.GRAY)
        canvas.translate(100f, 100f);
        canvas.drawRect(0f, 0f, 700f, 700f, mPaint);//由于平移操作，导致绘制的矩形超出了图层的大小，所以绘制不完全
//        canvas.restore();
        canvas.restoreToCount(saveLayer);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0f, 0f, 100f, 100f, mPaint);

        canvas.translate(0f, 1600f)//移动了一下 为了好看

        mPaint.setColor(Color.RED);
        canvas.drawCircle(300f,300f,30f,mPaint);
    }
}

