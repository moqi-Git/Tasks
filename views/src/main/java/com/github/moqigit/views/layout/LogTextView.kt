package com.github.moqigit.views.layout

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TextView
import com.github.moqigit.common.kLogE

class LogTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        kLogE("LogTextView#$this dispatchTouchEvent: ${ev?.actionMasked}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        kLogE("LogTextView#$this onTouchEvent: ${event?.actionMasked}")
        return super.onTouchEvent(event)
    }
}