package com.smallmarker.leetcode_kotlin.questions._0009

/**
 * @link https://leetcode.cn/problems/palindrome-number/description/
 * @author zl
 * @Date 2024/4/29
 **/
class Solution {

    // 如果整数为负数，则直接返回 false，因为负数不可能是回文数。
    // 初始化一个变量 reversed 为 0，用于存储整数反转后的结果。
    // 循环将整数的个位数取出并加到 reversed 的末尾，同时将整数除以 10，直到整数为 0。
    // 判断反转后的结果是否与原整数相等，相等则返回 true，否则返回 false。
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var num = x
        var reversed = 0
        while (num != 0) {
            val digit = num % 10
            reversed = reversed * 10 + digit
            num /= 10
        }
        return x == reversed
    }
}
