package easy

/**
 * 两数之和(数组,哈希表)
 * https://leetcode.cn/problems/two-sum/
 * 输入数组 nums 和目标值 target,在该数组中找出和为目标值的那两个整数,并返回它们的数组下标
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>() // 创建哈希表存储(值,索引)
    for ((index, value) in nums.withIndex()) { // 遍历数组
        val complement = target - value // 计算差值
        if (map.containsKey(complement)) { // 判断差值是否在哈希表中
            return intArrayOf(map[complement]!!, index) // 返回差值的索引和当前索引
        }else{
            map[value] = index // 将(值,索引)存入哈希表
        }
    }
    throw IllegalArgumentException("No two sum solution")
}
