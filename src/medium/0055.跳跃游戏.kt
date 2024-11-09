package medium

/**
 * 跳跃游戏(数组,贪心,动态规划)
 * https://leetcode.cn/problems/jump-game/
 * 给定一个非负整数数组 nums, 你最初位于数组的第一个位置, 数组中的每个元素代表你在该位置可以跳跃的最大长度, 判断你是否能够到达最后一个下标, 如果可以返回true,否则返回false
 * 输入: nums = [2,3,1,1,4]
 * 输出: true
 */
fun canJump(nums: IntArray): Boolean {
    var maxReach = 0 // 当前能到达的最远位置

    for (i in nums.indices) {
        // 如果当前位置 i 超过了当前能到达的最远位置 maxReach，返回 false
        if (i > maxReach) {
            return false
        }
        maxReach = maxOf(maxReach, i + nums[i]) // 更新maxReach
        // 如果 maxReach 已经达到或超过了最后一个下标，返回 true
        if (maxReach >= nums.size - 1) {
            return true
        }
    }
    return false // 如果遍历结束后仍未达到最后一个下标，返回 false
}