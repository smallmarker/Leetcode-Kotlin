package com.smallmarker.leetcode_kotlin.questions._0008

/**
 * @link https://leetcode.cn/problems/string-to-integer-atoi/description/
 * @author zl
 * @Date 2024/4/29
 **/
class Solution {

    // 读入字符串并丢弃无用的前导空格。
    // 检查下一个字符是正号还是负号，确定结果的正负性。
    // 读入连续的数字字符，直到遇到非数字字符或字符串结尾。
    // 将读入的数字字符转换为整数。
    // 根据符号和数字结果的大小，进行截断和判断是否超出32位有符号整数的范围。
    fun myAtoi(s: String): Int {
        var index = 0
        var sign = 1
        var result = 0

        // 去除前导空格
        while (index < s.length && s[index] == ' ') {
            index++
        }

        // 处理正负号
        if (index < s.length && (s[index] == '+' || s[index] == '-')) {
            sign = if (s[index++] == '-') -1 else 1
        }

        // 读入连续的数字字符
        while (index < s.length && s[index].isDigit()) {
            val digit = s[index++] - '0'
            // 判断是否越界
            if (result > (Int.MAX_VALUE - digit) / 10) {
                return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }
            result = result * 10 + digit
        }

        return sign * result
    }
}
