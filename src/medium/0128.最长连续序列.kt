package medium

/**
 * 最长连续序列(哈希表,数组,并查集)
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 * 给定一个未排序的整数数组nums,找出最长连续序列的长度(不要求序列元素在原数组中连续)
 * 输入: nums = [100,4,200,1,3,2]
 * 输出: 4 (最长连续序列是 [1, 2, 3, 4],其长度为 4)
 */
fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0 // 如果数组为空，直接返回 0

    val numSet = nums.toSet() // 数组转换Set去重集合
    var longestStreak = 0 // 最长序列的长度

    for (num in numSet) { // 遍历每个数字
        if (num - 1 !in numSet) { // 如果 num-1 不存在于集合中，说明 num 是连续序列的起点
            var currentNum = num  // 记录当前数字
            var currentStreak = 1 // 当前序列的长度

            while (currentNum + 1 in numSet) { // 查找后续的连续数字
                currentNum++
                currentStreak++
            }
            longestStreak = maxOf(longestStreak, currentStreak) // 更新最长序列的长度
        }
    }
    return longestStreak
}



