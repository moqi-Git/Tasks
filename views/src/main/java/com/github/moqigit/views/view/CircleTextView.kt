package com.github.moqigit.views.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CircleTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var attrRingColor = Color.GRAY
    private var attrTextSize = 20

    private val ringPaint = Paint()

    init {


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val wm = MeasureSpec.getMode(widthMeasureSpec)
        val hm = MeasureSpec.getMode(heightMeasureSpec)
        val ow = MeasureSpec.getSize(widthMeasureSpec)
        val oh = MeasureSpec.getSize(heightMeasureSpec)



        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}