package medium

/**
 * 和为 K 的子数组(哈希表,前缀和,数组)
 * https://leetcode.cn/problems/subarray-sum-equals-k
 * 给你一个整数数组 nums 和一个整数 k, 请你统计并返回该数组中和为 k 的子数组的个数 (子数组是数组中元素的连续非空序列)
 * 输入: nums = [1,2,3], k = 3
 * 输出: 2 ([1,2], [3])
 */
fun subarraySum(nums: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>() // (前缀和,次数)
    map[0] = 1 // 初始化为map添加(0,1)

    var sum = 0   // 临时记录前缀和
    var kCount = 0 // 记录和为k的子数组个数

    // 遍历数组, 计算前缀和
    for (value in nums) {
        sum += value

        // 原理: 两个前缀和相减结果为中间连续序列的和, 例如sum5-sum2=k
        // 已知当前遍历得到的sum5和中间连续序列和k, 则可检查map中是否存在sum2, 若存在则说明存在连续序列和为k, 存在几次即有几个连续序列
        if (map.containsKey(sum - k)) {
            kCount += map[sum - k]!! // sum2的存在次数即为连续序列的个数
        }

        // 统计前缀和sum出现的次数
        map[sum] = map.getOrDefault(sum, 0) + 1
    }
    return kCount
}

