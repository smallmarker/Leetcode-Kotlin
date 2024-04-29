package com.smallmarker.leetcode_kotlin.questions._0007

/**
 * @link https://leetcode.cn/problems/reverse-integer/description/
 * @author zl
 * @Date 2024/4/29
 **/
class Solution {

    // 提取整数的符号，记录整数是否为负数。
    // 对整数的绝对值进行反转。
    // 如果反转后的结果超出32位有符号整数的范围，则返回0，否则根据符号将结果返回为正数或负数。
    fun reverse(x: Int): Int {
        if (x == 0) return 0
        var num = x
        var isNegative = false
        if (num < 0) {
            isNegative = true
            num = -num
        }
        try {
            num = num.toString().reversed().toInt()
        } catch (e: NumberFormatException) {
            return 0
        }
        if (isNegative) {
            num = -num
        }
        return num
    }
}
