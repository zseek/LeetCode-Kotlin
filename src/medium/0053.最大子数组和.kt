package medium

/**
 * 最大子数组和(动态规划,数组,分治)
 * https://leetcode.cn/problems/maximum-subarray
 * 给定一个整数数组 nums, 找到一个具有最大和的连续子数组(子数组最少包含一个元素),返回其最大和,数组是数组中的一个连续部分。
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6 ([4,-1,2,1])
 */
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0] // 记录最大子数组和
    var currentSum = nums[0] // 记录当前子数组和

    for (i in 1..<nums.size) {
        // 计算当前子数组和，要么继续累加，要么从当前元素重新开始
        currentSum = maxOf(nums[i], currentSum + nums[i])
        // 更新全局最大子数组和
        maxSum = maxOf(maxSum, currentSum)
    }
    return maxSum
}

