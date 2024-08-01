package com.smallmarker.leetcode_kotlin.questions._0014

/**
 * @link https://leetcode.cn/problems/longest-common-prefix/description/
 * @author zl
 * @Date 2024/5/6
 **/
class Solution {

    // 初始化公共前缀为第一个字符串： 将公共前缀初始化为给定字符串数组中的第一个字符串。
    // 遍历字符串数组： 从第二个字符串开始，逐个与公共前缀进行比较，找到它们的最长公共前缀。
    // 更新公共前缀： 将找到的最长公共前缀更新为当前的公共前缀。
    // 返回结果： 完成遍历后，返回最终的公共前缀。
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var prefix = strs[0]
        for (i in 1 until strs.size) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length - 1)
                if (prefix.isEmpty()) return ""
            }
        }
        return prefix
    }
}
