package easy

/**
 * 多数元素(数组,哈希表,计数,排序,分治,计数)
 * https://leetcode.cn/problems/majority-element/
 * 给定一个大小为 n 的数组 nums, 返回其中的多数元素, 多数元素是指在数组中出现次数大于 n/2 的元素, 你可以假设数组是非空的, 并且给定的数组总是存在多数元素
 * 输入: nums = [3,2,3]
 * 输出: 3
 */
fun majorityElement(nums: IntArray): Int {
    var candidate = nums[0] // 初始化候选人
    var count = 0          // 初始化计数器

    for (num in nums) {
        if (count == 0) {  // 当前计数为 0，更新候选人
            candidate = num
        }
        count += if (num == candidate) 1 else -1  // 更新计数器
    }
    return candidate // 返回多数元素
}
