package com.smallmarker.leetcode_kotlin.questions._0011

/**
 * @link https://leetcode.cn/problems/container-with-most-water/description/
 * @author zl
 * @Date 2024/4/30
 **/
class Solution {

    // 初始化左指针 left 指向数组的开头，右指针 right 指向数组的末尾。
    // 使用变量 maxArea 记录当前最大容量，初始化为 0。
    // 在 left < right 的条件下执行以下步骤：
    // 计算当前容器的容量，即 min(height[left], height[right]) * (right - left)，并将其与 maxArea 比较，取较大值更新 maxArea。
    // 如果 height[left] < height[right]，则移动左指针 left 右移一位；否则，移动右指针 right 左移一位。
    // 返回 maxArea 即为最大容量。
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            val area = minOf(height[left], height[right]) * (right - left)
            maxArea = maxOf(maxArea, area)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return maxArea
    }
}
