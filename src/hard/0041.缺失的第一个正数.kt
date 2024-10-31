package hard

import kotlin.math.abs

/**
 * 缺失的第一个正数(数组,哈希表)
 * https://leetcode.cn/problems/first-missing-positive
 * 给你一个未排序的整数数组 nums, 请你找出其中没有出现的最小的正整数
 * 输入: nums = [1,2,0]
 * 输出: 3
 */
/*
fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    // 将每个数字放到值对应的索引位置(原地哈希)
    for (i in nums.indices) {
        // 条件1: 保证nums[i]为正数且不超过数组长度(超越数组长度的数一定不是缺失的最小正整数)
        // 条件2: 已经在正确位置上, 则不需要此步骤
        while (nums[i] in 1..n && i != (nums[i] - 1)) {
            val index = nums[i] - 1 // 对应的索引
            // 交换位置
            val temp = nums[i]
            nums[i] = nums[index]
            nums[index] = temp
        }
    }
    // 排好序后遍历数组, 完整的数组应该是 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    for (i in nums.indices) {
        if (nums[i] != i + 1) { // 不在对应位置上则缺失, 例如nums[0] = 1为正确位置
            return i + 1
        }
    }
    // 如果数组中的元素都在对应位置上，返回 n + 1
    return n + 1
}
 */

fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    // 将数组中的非正数替换为 n+1, 因为超出数组长度不影响结果, 也会跳过下面的原地标记哈希步骤
    for (i in nums.indices) {
        if (nums[i] <= 0) { nums[i] = n + 1 }
    }
    // 原地标记哈希
    for (i in nums.indices) {
        val num = abs(nums[i]) // 对nums[i]取绝对值
        if (num in 1..n) { // 在范围内则标记:取反
            nums[num - 1] = -abs(nums[num - 1]) // 对应的索引位置标记为负数
        }
    }
    // 查找缺失的最小正数
    for (i in nums.indices) {
        if (nums[i] > 0) {
            return i + 1
        }
    }
    // 如果所有位置都被标记为负数，则返回 n + 1
    return n + 1
}
