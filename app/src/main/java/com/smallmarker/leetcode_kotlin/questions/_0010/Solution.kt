package com.smallmarker.leetcode_kotlin.questions._0010

/**
 * @link https://leetcode.cn/problems/regular-expression-matching/description/
 * @author zl
 * @Date 2024/4/29
 **/
class Solution {

    // 如果 p[j] 是正常字符（不是 '.' 或 '*'），则 s[i] 必须和 p[j] 匹配，并且 dp[i][j] 取决于 dp[i-1][j-1]。
    // 如果 p[j] 是 '.'，则 s[i] 可以和任意字符匹配，同样 dp[i][j] 取决于 dp[i-1][j-1]。
    // 如果 p[j] 是 '*'，则有两种情况：
    // '*' 匹配零个前面的字符，这时 dp[i][j] 取决于 dp[i][j-2]。
    // '*' 匹配一个或多个前面的字符，这时 s[i] 必须和 p[j-1] 匹配，并且 dp[i][j] 取决于 dp[i-1][j]。
    fun isMatch(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length
        val dp = Array(m + 1) { BooleanArray(n + 1) }

        dp[0][0] = true
        for (j in 1..n) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2]
            }
        }

        for (i in 1..m) {
            for (j in 1..n) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1]
                } else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2]
                    if (p[j - 2] == s[i - 1] || p[j - 2] == '.') {
                        dp[i][j] = dp[i][j] or dp[i - 1][j]
                    }
                }
            }
        }

        return dp[m][n]
    }
}
