package com.smallmarker.leetcode_kotlin.questions._0004

/**
 * @link https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 * @author   zl
 * @Date     2024/3/25
 **/
class Solution {

    // 设定两个指针 left 和 right，分别初始化在两个数组的开头和结尾位置。
    // 利用二分查找的思想，在两个数组中分别找到一个分割点，使得左半部分的元素个数加上右半部分的元素个数等于总元素个数的一半。
    // 对于每一次二分查找，我们可以设定分割点在较短的数组中的中间位置，然后通过计算另一个数组中对应的位置，来判断分割点是否满足条件。
    // 如果满足条件，则根据总元素个数的奇偶性来确定中位数的值。
    // 如果不满足条件，根据分割点的位置调整 left 或 right 的值，进而进行下一轮的二分查找。
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val totalLeft = (m + n + 1) / 2
        var left = 0
        var right = m

        while (left < right) {
            val m1 = left + (right - left) / 2
            val m2 = totalLeft - m1

            if (nums1[m1] < nums2[m2 - 1]) {
                left = m1 + 1
            } else {
                right = m1
            }
        }

        val m1 = left
        val m2 = totalLeft - left

        val c1 = maxOf(if (m1 == 0) Int.MIN_VALUE else nums1[m1 - 1],
            if (m2 == 0) Int.MIN_VALUE else nums2[m2 - 1])

        if ((m + n) % 2 == 1) {
            return c1.toDouble()
        }

        val c2 = minOf(if (m1 == m) Int.MAX_VALUE else nums1[m1],
            if (m2 == n) Int.MAX_VALUE else nums2[m2])

        return (c1 + c2) / 2.0
    }
}
