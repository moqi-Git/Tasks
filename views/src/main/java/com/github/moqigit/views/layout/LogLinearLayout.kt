package com.github.moqigit.views.layout

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import com.github.moqigit.common.kLogE

class LogLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        kLogE("LogLinearLayout#$this dispatchTouchEvent: ${ev?.actionMasked}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        kLogE("LogLinearLayout#$this onInterceptTouchEvent: ${ev?.actionMasked}")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        kLogE("LogLinearLayout#$this onTouchEvent: ${event?.actionMasked}")
        return super.onTouchEvent(event)
    }
}