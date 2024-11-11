
## LeetCode 练习仓库

### 仓库说明

- [x] 本仓库用于记录 LeetCode 练习题的解题思路和代码, 使用 Kotlin 语言进行编写, IntelliJ 进行构建, JDK17作为运行环境

### 仓库目录

- obsidian: 用于存放LeetCode练习题的笔记
- src
    - easy: 简单
    - medium: 中等
    - hard: 困难

### 仓库规范

文件名为 LeetCode `题目序号.题目名称`, 文件规范如下: 
```kotlin
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
```
