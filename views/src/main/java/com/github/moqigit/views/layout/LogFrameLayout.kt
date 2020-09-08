package com.github.moqigit.views.layout

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.github.moqigit.common.kLogE

class LogFrameLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        kLogE("LogFrameLayout#$this dispatchTouchEvent: ${ev?.actionMasked}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        kLogE("LogFrameLayout#$this onInterceptTouchEvent: ${ev?.actionMasked}")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        kLogE("LogFrameLayout#$this onTouchEvent: ${event?.actionMasked}")
        return super.onTouchEvent(event)
    }
}