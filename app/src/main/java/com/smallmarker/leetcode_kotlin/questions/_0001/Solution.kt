package com.smallmarker.leetcode_kotlin.questions._0001

/**
 * @see https://leetcode.cn/problems/two-sum/description/
 * @author   zl
 * @Date     2024/3/22
 **/
class Solution {

    // 这道题目可以通过使用哈希表来实现时间复杂度为 O(n) 的解法。具体步骤如下：
    //
    // 创建一个空的哈希表（或者 HashMap），用于存储数组中的元素及其对应的下标。
    // 遍历数组，对于每个元素 nums[i]，检查哈希表中是否存在 target - nums[i]，即是否存在与当前元素相加等于目标值的另一个元素。
    // 如果存在，则返回当前元素的下标 i 和哈希表中存储的另一个元素的下标。
    // 如果不存在，则将当前元素及其下标加入哈希表中。

    fun twoSum(nums: IntArray, target: Int): IntArray {
        //创建一个哈希表，用于存储元素及其下标
        val map = mutableMapOf<Int, Int>()
        //遍历数组
        for (i in nums.indices) {
            //计算当前元素与目标值的差值
            val t = target - nums[i]
            //如果差值存在于哈希表中，则返回结果
            if (map.containsKey(t)) {
                return intArrayOf(map[t]!!, i)
            }
            //否则将当前元素及其下标加入哈希表中
            map[nums[i]] = i
        }
        //如果没有找到符合条件的结果，则返回空数组
        return intArrayOf()
    }
}

