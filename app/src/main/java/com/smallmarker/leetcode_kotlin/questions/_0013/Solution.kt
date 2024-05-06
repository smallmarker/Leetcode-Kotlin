package com.smallmarker.leetcode_kotlin.questions._0013

/**
 * @link https://leetcode.cn/problems/roman-to-integer/description/
 * @author zl
 * @Date 2024/4/30
 **/
class Solution {

    // 创建罗马数字映射表： 首先，创建一个哈希映射，将罗马数字字符与其对应的数值关联起来。例如，'I' 对应 1，'V' 对应 5，以此类推。
    // 迭代字符串： 从字符串的最后一个字符开始向前迭代，因为通常情况下，罗马数字中较小的数字在较大的数字的右边。这样做可以更容易处理罗马数字中特殊情况的情况。
    // 计算整数值： 对于每个字符，从映射表中查找其对应的数值。根据罗马数字的规则，如果一个数字右边的数字比它大，则将该数字的值加到结果中；否则，将该数字的值减去结果。这是因为，例如，IV 表示 4，其中 I(1) 在 V(5) 的左边，所以 IV 的值是 5-1=4。
    // 返回结果： 完成字符串的迭代后，返回计算得到的整数值作为结果。
    fun romanToInt(s: String): Int {
        val romanMap = hashMapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var result = 0
        var prevValue = 0
        for (i in s.length - 1 downTo 0) {
            val currValue = romanMap[s[i]]!!
            if (currValue < prevValue) {
                result -= currValue
            } else {
                result += currValue
            }
            prevValue = currValue
        }
        return result
    }
}
