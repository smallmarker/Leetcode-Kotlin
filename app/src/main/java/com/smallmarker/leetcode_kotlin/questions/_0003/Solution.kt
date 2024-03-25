package com.smallmarker.leetcode_kotlin.questions._0003

import kotlin.math.max

/**
 * @link https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * @author   zl
 * @Date     2024/3/25
 **/
class Solution {

    // 使用两个指针表示滑动窗口的左右边界，初始时都指向字符串的开头。
    // 遍历字符串，右指针向右移动，同时更新滑动窗口的内容。
    // 如果遇到重复字符，左指针向右移动，直到滑动窗口中不再含有重复字符为止。
    // 在遍历过程中不断更新最长无重复字符子串的长度。
    // 最终返回最长无重复字符子串的长度。

    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var maxLength = 0
        val map = mutableMapOf<Char, Int>()
        for (right in s.indices) {
            val char = s[right]
            if (map.containsKey(char)) {
                left = max(left, map[char]!! + 1)
            }
            map[char] = right
            maxLength = max(maxLength, right - left + 1)
        }
        return maxLength
    }
}
