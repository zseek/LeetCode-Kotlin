package easy

/**
 * 移动零(数组,双指针)
 * https://leetcode.cn/problems/move-zeroes/
 * 给定一个数组 nums,编写一个函数将所有 0 移动到数组的末尾,同时保持非零元素的相对顺序
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
fun moveZeroes(nums: IntArray) {
    var nonZeroIndex = 0 // 定义一个指针，用于指向非零元素应该放置的位置
    for (value in nums) { // 遍历整个数组
        if (value != 0) { // 如果当前元素不是0
            nums[nonZeroIndex] = value // 将它移动到 nonZeroIndex 指向的位置
            nonZeroIndex++ // 移动指针
        }
    }
    // 已经将num中的非零元素移动到前面了, 现在只需要将后面的元素全部置为0即可
    for (i in nonZeroIndex..<nums.size) {
        nums[i] = 0
    }
}


