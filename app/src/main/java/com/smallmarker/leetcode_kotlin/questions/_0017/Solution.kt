package com.smallmarker.leetcode_kotlin.questions._0017

/**
 * @link https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 * @author zl
 * @Date 2024/8/5
 **/
class Solution {

    // 映射关系：首先定义一个映射关系，将数字 2-9 映射到对应的字母集。
    // 回溯法：使用回溯法生成所有可能的组合。
    // 对于每个数字，选择它对应的一个字母，然后递归处理剩下的数字。
    // 当所有数字都处理完后，当前的组合就是一个有效的结果。
    // 边界条件：如果输入的字符串为空，则直接返回空列表。
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return listOf()
        val map = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz",
        )
        val result = mutableListOf<String>()
        fun backTrack(combination: String, nextDigits: String) {
            if (nextDigits.isEmpty()) {
                result.add(combination)
            } else {
                val digit = nextDigits[0] // abc
                map[digit]?.let {
                    for (letter in it) {
                        backTrack(combination + letter, nextDigits.substring(1))
                    }
                }
            }
        }
        backTrack("", digits)
        return result
    }
}
