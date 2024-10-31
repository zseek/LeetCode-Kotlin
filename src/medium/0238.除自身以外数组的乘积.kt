package medium

/**
 * 除自身以外数组的乘积(数组,前缀和)
 * https://leetcode.cn/problems/product-of-array-except-self
 * 给你一个整数数组 nums,返回输出数组 answer, 其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积, 题目数据保证数组 nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内, 请不要使用除法，
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 */
fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val answer = IntArray(nums.size)

    // 计算前缀积
    var prefix = 1
    answer[0] = 1
    for (i in nums.indices) {
        if (i > 0) {
            prefix *= nums[i - 1]
            answer[i] = prefix // 暂存每个前缀积
        }
    }
    // 计算后缀积
    var suffix = 1
    for (i in nums.indices.reversed()) {
        if(i != n-1) { suffix *= nums[i+1] }
        answer[i] *= suffix // 前缀积 * 后缀积 得到结果answer
    }
    return answer
}
