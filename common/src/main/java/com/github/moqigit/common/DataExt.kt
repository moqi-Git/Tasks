package com.github.moqigit.common

import java.lang.StringBuilder

/**
 *
 * created by reol at 2020/8/2
 */

fun IntArray.toLog(): String{
    val sb = StringBuilder()
    sb.append('[')

    for (i in this){
        sb.append(i).append(',')
    }

    sb.deleteCharAt(sb.length - 1)
    sb.append(']')
    return sb.toString()
}