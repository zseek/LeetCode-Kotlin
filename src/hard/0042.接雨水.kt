package hard

/**
 * 接雨水(数组,栈,双指针,动态规划,单调栈)
 * https://leetcode.cn/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图,计算按此排列的柱子,下雨之后能接多少雨水
 * 输入: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
fun trap(height: IntArray): Int {
    if (height.isEmpty()) return 0 // 如果数组为空，直接返回 0

    var left = 0 // 左指针
    var right = height.size - 1 // 右指针
    var leftMax = 0 // 左侧最大高度
    var rightMax = 0 // 右侧最大高度
    var total = 0 // 总共接的雨水

    while (left < right) {
        if (height[left] < height[right]) { // 左侧柱子较矮,看左侧

            if (height[left] >= leftMax) { // 当前柱子高度大于最大高度时，更新最大高度
                leftMax = height[left]
            } else { // 当前柱子高度小于最大高度时，差值就是可以存储的水量
                total += (leftMax - height[left])
            }

            left++ // 完成后移动指针
        } else { // 右侧柱子较矮,看右侧

            if (height[right] >= rightMax) { // 当前柱子高度大于最大高度时，更新最大高度
                rightMax = height[right]
            } else { // 当前柱子高度小于最大高度时，差值就是可以存储的水量
                total += (rightMax - height[right])
            }

            right-- // 完成后移动指针
        }
    }
    return total
}
