package hard

/**
 * 滑动窗口最大值(队列,数组,滑动窗口,单调队列,堆(优先队列))
 * https://leetcode.cn/problems/sliding-window-maximum
 * 给你一个整数数组 nums, 有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧, 你只可以看到在滑动窗口内的 k 个数字, 滑动窗口每次只向右移动一位, 返回每次滑动窗口中的最大值
 * 输入: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出: [3,3,5,5,6,7]
 */
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k == 0) return intArrayOf()

    val deque = ArrayDeque<Int>() // 存储元素索引的双端队列
    val result = IntArray(nums.size - k + 1) // 结果数组

    for (i in nums.indices) { // 遍历数组
        // 向右滑动过程中, 移除超出滑动窗口范围的左侧元素(未完全进入数组时不执行,此时first为1)
        if (deque.isNotEmpty() && deque.first() < i - k + 1) { // i-k+1为滑动窗口左边界索引, first为双端队列左端索引
            deque.removeFirst()
        }
        // 向右滑动过程中, 若新元素大于双端队列右侧元素, 则移除队列右侧该元素
        while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
            deque.removeLast()
        }
        // step1: 向右滑动过程中将数组中当前元素的索引加入双端队列右侧(滑动窗口的右边界从数组的左边进入开始移动)
        deque.addLast(i)
        // step2: 窗口完全进入数组后, 每次移动窗口时, 都将当前窗口的最大值（队列头部元素）加入结果数组
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.first()]
        }
    }
    return result
}