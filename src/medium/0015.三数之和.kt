package medium

/**
 * 三数之和(数组,双指针,排序)
 * https://leetcode.cn/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums,判断 nums 中是否存在三个元素 a, b, c,使得 a + b + c = 0? 请你找出所有满足条件且不重复的三元组
 * 输入: nums = [-1, 0, 1, 2, -1, -4]
 * 输出: [[-1, -1, 2], [-1, 0, 1]]
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>() // 用于存储结果
    nums.sort() // 先对数组进行排序方便后续操作

    // 遍历每个元素，将其作为固定数
    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue // 固定数跳过重复的元素(排序后重复的元素会相邻)

        // 使用双指针查找另外两个数,使其和为 0-nums[i]
        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right] // 计算三个数的和
            when {
                sum == 0 -> { // 和为0, 找到三元组
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    // 双指针跳过重复的元素,指向下一个不同的元素
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--

                    // 移动指针,指向下一个不同的元素
                    left++
                    right--
                }
                sum < 0 -> { // 和小于0,移动左指针增加总和
                    left++
                }
                else -> right-- // 和大于0,移动右指针减少总和
            }
        }
    }
    return result
}



