package medium

/**
 * 在排序数组中查找元素的第一个和最后一个位置(数组,二分查找)
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums, 和一个目标值 target, 找出给定目标值在数组中的开始位置和结束位置, 如果数组中不存在目标值 target, 返回[-1, -1]
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    // 找到目标值的第一个位置
    fun findFirst(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] >= target) { // 偏左查找
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left < nums.size && nums[left] == target) left else -1
    }

    // 找到目标值的最后一个位置
    fun findLast(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] <= target) { // 偏右查找
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return if (right >= 0 && nums[right] == target) right else -1
    }

    val first = findFirst(nums, target)
    val last = findLast(nums, target)
    return intArrayOf(first, last)
}
