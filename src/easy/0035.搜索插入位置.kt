package easy

/**
 * 搜索插入位置(数组,二分查找)
 * https://leetcode.cn/problems/search-insert-position/
 * 给定一个排序数组和一个目标值, 在数组中找到目标值, 并返回其索引, 如果目标值不存在于数组中, 返回它将会被按顺序插入的位置
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2  // 防止溢出，计算中间位置
        if (nums[mid] == target) {           // 找到目标值，返回其索引
            return mid
        } else if (nums[mid] < target) {     // 目标值在右半部分
            left = mid + 1
        } else {                             // 目标值在左半部分
            right = mid - 1
        }
    }
    return left  // 未找到目标值，返回插入位置
}
