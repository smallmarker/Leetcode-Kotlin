package com.smallmarker.leetcode_kotlin.questions._0006

/**
 * @link https://leetcode.cn/problems/zigzag-conversion/description/
 * @author zl
 * @Date 2024/4/28
 **/
class Solution {
    // 创建 numRows 个字符串，用于存储 Z 字形排列后每一行的字符。
    // 遍历字符串 s 中的每个字符，根据 Z 字形排列的规则确定该字符应该放置在哪一行。
    // 根据字符的顺序，逐个将字符添加到对应的行中。
    // 最后，将每一行的字符拼接起来，得到最终的结果字符串。
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || s.length <= numRows) return s
        val rows = Array(numRows) { StringBuilder() }
        var curRow = 0
        var goingDown = false
        for (c in s) {
            rows[curRow].append(c)
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown
            }
            curRow += if (goingDown) 1 else -1
        }
        val result = java.lang.StringBuilder()
        for (row in rows) {
            result.append(row)
        }
        return result.toString()
    }
}
