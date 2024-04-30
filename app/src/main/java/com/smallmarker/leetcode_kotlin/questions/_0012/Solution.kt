package com.smallmarker.leetcode_kotlin.questions._0012

/**
 * @link https://leetcode.cn/problems/integer-to-roman/description/
 * @author zl
 * @Date 2024/4/30
 **/
class Solution {

    // 初始化一个空字符串 result 用于存储转换后的罗马数字。
    // 枚举罗马数字字符和对应的数值，按照从大到小的顺序遍历：
    // 如果当前数值小于等于 num，则将对应的罗马数字字符拼接到 result 中，并将 num 减去对应的数值。
    // 如果当前数值大于 num，则继续枚举下一个罗马数字字符。
    // 返回 result 即为转换后的罗马数字表示。
    fun intToRoman(num: Int): String {
        val m = mutableMapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )
        var result = ""
        var n = num
        m.forEach { (t, u) ->
            while (n >= t) {
                result += u
                n -= t
            }
        }
        return result
    }
}
