package medium

/**
 * 跳跃游戏(数组,贪心,动态规划)
 * https://leetcode.cn/problems/jump-game/
 * 给定一个非负整数数组 nums, 你最初位于数组的第一个位置, 数组中的每个元素代表你在该位置可以跳跃的最大长度, 判断你是否能够到达最后一个下标, 如果可以返回true,否则返回false
 * 输入: nums = [2,3,1,1,4]
 * 输出: true
 */
fun canJump(nums: IntArray): Boolean {
    var maxReach = 0  // 记录当前能到达的最远位置

    for (i in nums.indices) {
        if (i > maxReach) {    // 当前索引已经超过了可达范围
            return false       // 说明无法到达终点
        }
        maxReach = maxOf(maxReach, i + nums[i])  // 更新最远可达位置
        if (maxReach >= nums.lastIndex) {        // 检查是否能到达或超过最后一个位置
            return true
        }
    }
    return false  // 如果遍历完成还未返回，说明无法到达
}
