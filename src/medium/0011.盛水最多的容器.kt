package medium

/**
 * 盛水最多的容器(数组,双指针,贪心)
 * https://leetcode.cn/problems/container-with-most-water/
 * 给定一个长度为 n 的整数数组 height,其中 height[i] 表示一个柱子的高度, 两根柱子与 X 轴可以构成一个容器,找出容器能装的最大水量
 * 输入: height = [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
fun maxArea(height: IntArray): Int {
    var left = 0 // 左指针
    var right = height.size - 1 // 右指针
    var maxArea = 0 // 最大面积

    while (left < right) {
        val currentArea = (right - left) * minOf(height[left], height[right]) // 计算当前的面积
        maxArea = maxOf(maxArea, currentArea) // 更新最大面积

        // 移动指针，优先移动高度较小的柱子
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}

/*
// LeetCode 使用 minOf 超时时的解决方案
fun maxArea(height: IntArray): Int {
    var left = 0 // 左指针
    var right = height.size - 1 // 右指针
    var maxArea = 0 // 最大面积
    var currentArea = 0 // 当前面积

    // 使用双指针从数组两端向中间移动
    while (left < right) {
        // 移动指针并计算当前的面积
        if (height[left] < height[right]) {
            currentArea = (right - left) * height[left]
            left++ // 移动左指针
        } else {
            currentArea = (right - left) * height[right]
            right-- // 移动右指针
        }
        maxArea = maxOf(maxArea, currentArea) // 更新最大面积
    }
    return maxArea
}
 */