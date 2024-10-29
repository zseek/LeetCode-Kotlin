package medium


/**
 * 轮转数组(数组,数学,双指针)
 * https://leetcode.cn/problems/rotate-array
 * 给定一个数组 nums, 将数组中的元素向右移动 k 个位置, 其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 */
fun rotate(nums: IntArray, k: Int) {
    val n = nums.size
    val rotations = k % n // 计算实际反转次数, k>n时取余数, 例如数组长度为m=7, k=10, 等价于k=3

    // 辅助翻转函数,输入数组nums的翻转区间[start,end],将区间内元素翻转
    fun reverse(start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) { // swap部分,用于交换元素
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }

    // 三次翻转: [1,2,3,4,5,6,7], n=7, k=3
    reverse(0, n - 1) // 翻转整个数组: [7,6,5,4,3,2,1]
    reverse(0, rotations - 1) // 翻转前 3 个元素: [5,6,7,4,3,2,1]
    reverse(rotations, n - 1) // 翻转后 4 个元素: [5,6,7,1,2,3,4]
}


