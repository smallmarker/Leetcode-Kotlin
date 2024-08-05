package com.smallmarker.leetcode_kotlin.questions._0015

/**
 * @link https://leetcode.cn/problems/3sum/description/
 * @author zl
 * @Date 2024/7/31
 **/
class Solution {

    // 排序：首先对数组进行排序，这样我们可以方便地跳过重复的元素，并且可以利用双指针来寻找符合条件的三元组。
    // 遍历数组：遍历排序后的数组，对于每个元素 nums[i]，我们尝试找到两个数 nums[j] 和 nums[k]，使得 nums[i] + nums[j] + nums[k] == 0。我们可以通过双指针的方法来找到这两个数。
    // 双指针查找：
    // 对于每个 i，设 j = i + 1，k = nums.size - 1。
    // 如果 nums[i] + nums[j] + nums[k] == 0，那么我们找到了一个符合条件的三元组。
    // 如果和小于 0，说明 nums[j] 太小了，j 需要右移。
    // 如果和大于 0，说明 nums[k] 太大了，k 需要左移。
    // 为了避免重复的三元组，i、j 和 k 需要跳过相同的元素。
    // 返回结果：最后，将所有符合条件的三元组加入到结果集中返回。
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[j], nums[k]))
                        while (j < k && nums[j] == nums[j + 1]) j++
                        while (j < k && nums[k] == nums[k - 1]) k--
                        j++
                        k--
                    }
                    sum < 0 -> j++
                    else -> k--
                }
            }
        }
        return result
    }
}
