package com.github.moqigit.views.learn.audiowave

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.github.moqigit.common.kLogE
import com.github.moqigit.views.R
import java.util.*

/**
 *
 * created by reol at 2020/7/30
 */
class AudioWaveView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val defWaveColor = Color.BLACK
    private val defWaveWidth = 12f
    private val defWaveInterval = 4f

    private var aWaveColor = defWaveColor
    private var aWaveWidth = defWaveWidth
    private var aWaveInterval = defWaveInterval

    private var finalWidth = 0
    private var finalHeight = 0
    private var finalWaveCount = 0
    private val waveList = LinkedList<Int>()

    private val pWave = Paint()

    private val rect = RectF()

    init {

        val ta = context.resources.obtainAttributes(attrs, R.styleable.AudioWaveView)
        initAttrs(ta)
        initPaints()
        ta.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        finalWidth = measuredWidth
        finalHeight = measuredHeight

        fillEmptyWaveList()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null){
            return
        }

        while (waveList.size > finalWaveCount){
            waveList.poll()
        }

        for (i in 0 until waveList.size){
            rect.left = left + i*(aWaveWidth + aWaveInterval)
            rect.right =  left + i*(aWaveWidth + aWaveInterval) + aWaveWidth
            rect.top = (bottom - waveList[i]).toFloat()
            rect.bottom = bottom.toFloat()

            kLogE("rect $i, l=${rect.left}, r=${rect.right}, t=${rect.top}, b=${rect.bottom}")

            canvas.drawRect(rect, pWave)
        }
    }

    fun pushValue(value: Double){
        val height = (finalHeight * value).toInt()
        waveList.offer(height)
        invalidate()
    }


    private fun fillEmptyWaveList(){
        finalWaveCount = ((finalWidth - aWaveInterval) / (aWaveWidth + aWaveInterval)).toInt()

        kLogE("waveCount = $finalWaveCount, finalWidth = $finalWidth, waveHeight = $finalHeight")

        waveList.clear()
        repeat(finalWaveCount){
            waveList.offer((finalHeight * Math.random()).toInt())
        }
    }

    private fun initPaints(){
        pWave.color = aWaveColor
        pWave.isAntiAlias = true
        pWave.style = Paint.Style.FILL
    }

    private fun initAttrs(ta: TypedArray){
        aWaveColor = ta.getColor(R.styleable.AudioWaveView_waveColor, defWaveColor)
        aWaveWidth = ta.getDimension(R.styleable.AudioWaveView_waveWidth, defWaveWidth)
        aWaveInterval = ta.getDimension(R.styleable.AudioWaveView_waveInterval, defWaveInterval)
    }

}