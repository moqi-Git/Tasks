package com.github.moqigit.views.layout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.NestedScrollingParent3
import com.github.moqigit.common.kLogE
import com.github.moqigit.common.toLog

/**
 *
 * created by reol at 2020/8/2
 */
class NestedAdaptLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr),NestedScrollingParent3 {

    private var mCanScrollDistance = 40f


    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
//        kLogE("onNestedScrollAccepted: $child, $target, $axes, $type")
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        kLogE("onStartNestedScroll: $child, $target, $axes, $type")
        return true
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
//        kLogE("onNestedPreScroll: $target, $dx, $dy, ${consumed.toLog()}, $type")
//        kLogE("onNestedPreScroll: $scrollY, $mCanScrollDistance")
        if (dy > 0){
            kLogE("上")
            if (scrollY < mCanScrollDistance){
                val remain = (mCanScrollDistance - scrollY).toInt()
                if (remain > dy){
                    scrollBy(0, dy)
                    consumed[1] += dy
                } else {
                    scrollBy(0, remain)
                    consumed[1] += remain
                }
            }

        }
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
//        kLogE("onNestedScroll1: $dxConsumed, $dyConsumed, $dxUnconsumed, $dyUnconsumed, $type, ${consumed.toLog()}")
//        kLogE("onNestedScroll1: $scrollY, $mCanScrollDistance")
        if (dyUnconsumed < 0){
            kLogE("下")
            if (scrollY > 0){
                if (scrollY > -dyUnconsumed){
                    scrollBy(0, dyUnconsumed)
                    consumed[1] += dyUnconsumed
                } else {
                    scrollBy(0, -scrollY)
                    consumed[1] += -scrollY
                }
            }

        }

    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
//        kLogE("onNestedScroll2: $target, $dxConsumed, $dyConsumed, $dxUnconsumed, $dyUnconsumed, $type")
    }

    override fun onStopNestedScroll(target: View, type: Int) {
        kLogE("onStopNestedScroll: $target, $type")
    }

    fun setKeepDistance(distance: Float){
        mCanScrollDistance = distance
    }
}