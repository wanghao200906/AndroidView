package com.example.androidview.widget.basicView

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi


class BasicView05_Path : View {

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
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, 1000000)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //1、 moveTo   lineTo   close
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.textSize = 50f
        canvas.drawText("moveTo lineTo  rLineTo close的用法", 10f, 100f, mPaint)
        canvas.translate(0f, 200f)//移动了一下 为了好看
        mPaint.color = Color.RED
//       一阶贝塞尔曲线就是一条直线。
        val mPath: Path = Path()
        mPath.moveTo(100f, 70f)//移动。从0，0点移动到100,70点
//        mPath.lineTo(140f, 800f)//连线，和140，800这个点连线
        // 和 mPath.lineTo(140f, 800f) 这一句的效果是一样的。
        //含义就是根据当前点的位置绘制到传入参数的那个点。比如当前点是100f,70f，那么就相对当前点100f,70f，向右移动40f,向下移动770f距离
        mPath.rLineTo(40f, 770f)
        mPath.lineTo(250f, 600f)//连线，和250，600这个点连线
        mPath.close()//两paht的头和尾闭合。两个点进行连线。设置path是否会闭合
        canvas.drawPath(mPath, mPaint)//绘制path
        canvas.restore()
        canvas.translate(0f, 1600f)//移动了一下

        //2、添加各种弧形
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.textSize = 50f
        canvas.drawText("addArc addRect addCircle addOval 的用法", 10f, 100f, mPaint)
        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
        val mPath2: Path = Path()
//        startAngle 表示开始的角度， sweepAngle 表示扫过的角度
        mPath2.addArc(200f, 200f, 400f, 400f, -225f, 225f)
//         Path.Direction.CW表示顺时针绘制， Path.Direction.CCW 表示逆时针绘制
        mPath2.addRect(200f, 500f, 400f, 800f, Path.Direction.CW)
//绘制圆形
        mPath2.addCircle(700f, 700f, 200f, Path.Direction.CW)
//        绘制椭圆形
        mPath2.addOval(200f, 1000f, 400f, 1500f, Path.Direction.CCW)
        canvas.drawPath(mPath2, mPaint)//绘制path
        canvas.restore()
        canvas.translate(0f, 1600f)//移动了一下


        //3、追加图形  artTo ,还有很多 xxxTo的方法都一个意思
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 50f
        canvas.drawText("追加图形 artTo 的用法 其他用法类似", 10f, 100f, mPaint)
        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
        val mPath3: Path = Path()
        mPath3.addArc(200f, 200f, 400f, 400f, -225f, 225f)
//        forceMoveTo 为true,绘制的时候移动起点，为false，绘制的时候将path的上一个尾点和绘制的起点连气力啊
        mPath3.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
        canvas.drawPath(mPath3, mPaint)//绘制path
        canvas.restore()

        canvas.translate(0f, 600f)//移动了一下

        //4、理解forceMoveTo
//        forceMoveTo 为true,绘制的时候移动起点，为false，绘制的时候将path的上一个尾点和绘制的起点连气力啊
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 50f
        canvas.drawText("理解forceMoveTo 的用法  下面是用法", 10f, 100f, mPaint)
        canvas.drawText("理解forceMoveTo true ", 10f, 200f, mPaint)
        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
        val mPath4: Path = Path()
        mPath4.moveTo(200f, 200f)
        mPath4.lineTo(200f, 500f)
        mPath4.arcTo(400f, 200f, 600f, 400f, 0f, 225f, true)
        canvas.drawPath(mPath4, mPaint)//绘制path

        mPaint.setColor(Color.BLACK);
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 50f
        canvas.drawText("理解forceMoveTo false ", 10f, 800f, mPaint)
        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
        val mPath5: Path = Path()
        mPath5.moveTo(200f, 1000f)
        mPath5.lineTo(200f, 1500f)
        mPath5.arcTo(400f, 1200f, 600f, 1400f, 0f, 225f, false)
        canvas.drawPath(mPath5, mPaint)//绘制path

        canvas.restore()



        canvas.translate(0f, 2000f)//移动了一下

        //5、addPath
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 50f
        canvas.drawText("理解addPath的用法 画了两个path", 10f, 100f, mPaint)
        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
        val mPath6: Path = Path()
        val mPath7: Path = Path()

        mPath6.moveTo(100f, 70f)
        mPath6.lineTo(140f, 180f)
        mPath6.lineTo(250f, 330f)

        mPath7.moveTo(100f, 500f)
        mPath7.lineTo(140f, 680f)
        mPath7.lineTo(250f, 930f)

        mPath7.addPath(mPath6)//add Path 让多个path组合起来
        canvas.drawPath(mPath7, mPaint)//绘制path
        canvas.restore()

        //6、圆角矩形
        canvas.translate(0f, 1500f)//移动了一下
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 50f
        canvas.drawText("addRoundRect 绘制圆角矩形", 10f, 100f, mPaint)
        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
        val mPath8: Path = Path()
        val rect = RectF(200f, 200f, 700f, 1200f)
        mPath8.addRoundRect(rect, 20f, 20f, Path.Direction.CCW)
        canvas.drawPath(mPath8, mPaint)//绘制path
        canvas.restore()

        canvas.translate(0f, 1500f)//移动了一下


        //7、贝塞尔曲线
        canvas!!.save()
        mPaint.setColor(Color.BLACK);
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 50f
        canvas.drawText("贝塞尔曲线 的用法", 10f, 100f, mPaint)
        canvas.drawText("二阶贝塞尔曲线 的用法", 10f, 200f, mPaint)

        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
//        画二阶贝塞尔曲线 有一个控制点
        val mPath9: Path = Path()
        mPath9.moveTo(100f, 500f)
//        x1,x2为控制点，x2,y2为结束点
        mPath9.quadTo(500f, 100f, 800f, 500f)
//        参数表示相对位置，等同于上面一行代码
//        mPath9.rQuadTo(200f, -400f, 500f, 0f)
        canvas.drawPath(mPath9, mPaint)//绘制path


        mPaint.setColor(Color.BLACK);
        mPaint.style = Paint.Style.FILL
        mPaint.textSize = 50f
        canvas.drawText("三阶贝塞尔曲线 的用法", 10f, 700f, mPaint)

        mPaint.style = Paint.Style.STROKE
        canvas.translate(0f, 100f)//移动了一下 为了好看
        mPaint.color = Color.RED
//        画三阶贝塞尔曲线 有两个控制点
        val mPath10: Path = Path()
        mPath10.moveTo(100f, 900f)
//        x1,x2为控制点，x2,y2为控制点，
        mPath10.cubicTo(500f, 1000f, 800f, 500f,1000f,900f)
//        参数表示相对位置，等同于上面一行代码
//        mPath10.rQuadTo(200f, -400f, 500f, 0f)
        canvas.drawPath(mPath10, mPaint)//绘制path

        canvas.restore()
    }
}

