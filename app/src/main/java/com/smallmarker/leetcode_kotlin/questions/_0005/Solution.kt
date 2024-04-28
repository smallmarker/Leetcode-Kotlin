package com.smallmarker.leetcode_kotlin.questions._0005

/**
 * @link https://leetcode.cn/problems/longest-palindromic-substring/description/
 * @author zl
 * @Date 2024/4/28
 **/
class Solution {

    // 初始化二维数组 dp，将所有长度为 1 的子串都初始化为 true，即 dp[i][i] = true。
    // 从长度为 2 的子串开始，遍历字符串 s 的所有子串，更新 dp[i][j] 的值，如果 s[i] == s[j] 且 dp[i+1][j-1] 也为 true，则 dp[i][j] 为 true，否则为 false。
    // 在更新过程中记录最长的回文子串的起始位置和长度，以便最后返回结果。
    fun longestPalindrome(s: String): String {
        val n = s.length
        var start = 0
        var maxLen = 0
        val dp = Array(n) { BooleanArray(n) }

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                dp[i][j] = s[i] == s[j] && (j - i < 3 || dp[i + 1][j - 1])

                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i
                    maxLen = j - i + 1
                }
            }
        }

        return s.substring(start, start + maxLen)
    }
}
