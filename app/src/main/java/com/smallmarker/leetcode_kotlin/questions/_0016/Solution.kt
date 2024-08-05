package com.smallmarker.leetcode_kotlin.questions._0016

import kotlin.math.abs

/**
 * @link https://leetcode.cn/problems/3sum-closest/description/
 * @author zl
 * @Date 2024/8/2
 **/
class Solution {

    // 排序数组：
    // 首先对数组 nums 进行排序，以便我们可以使用双指针来寻找接近 target 的三个数之和。
    // 遍历数组：
    // 对于每个 nums[i]，我们将问题转化为在剩余的数组中寻找两个数，使它们与 nums[i] 的和最接近 target。
    // 使用双指针：
    // 定义两个指针，j 指向当前元素的下一个元素，k 指向数组的末尾。根据当前和与 target 的比较，调整 j 和 k 以寻找最接近 target 的和。
    // 更新最接近的和：
    // 在遍历过程中，记录最接近 target 的三数之和。
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = nums[0] + nums[1] + nums[2]
        for (i in nums.indices) {
            var j = i + 1
            var k = nums.lastIndex
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                if (sum == target) return sum
                if (abs(sum - target) < abs(result - target)) {
                    result = sum
                }
                if (sum < target) {
                    j++
                } else {
                    k--
                }
            }
        }
        return result
    }
}
