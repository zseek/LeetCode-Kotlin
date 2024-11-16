package medium

/**
 * 搜索二维矩阵(数组,二分查找,矩阵)
 * https://leetcode.cn/problems/search-a-2d-matrix/
 * 给你一个 m x n 的矩阵 matrix, 每行中的整数从左到右按非严格递增顺序排列, 每行的第一个整数大于前一行的最后一个整数, 给你一个整数 target, 如果 target在矩阵中, 返回 true, 否则返回 false
 * 输入: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出: true
 */
private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size          // 矩阵的行数
    val n = matrix[0].size       // 矩阵的列数
    var left = 0                 // 初始化左边界
    var right = m * n - 1        // 初始化右边界

    while (left <= right) {
        val mid = left + (right - left) / 2   // 计算中间索引
        val midValue = matrix[mid / n][mid % n] // 将一维索引映射到二维矩阵

        if (midValue == target) {            // 找到目标值
            return true
        } else if (midValue < target) {      // 目标值在右侧
            left = mid + 1
        } else {                             // 目标值在左侧
            right = mid - 1
        }
    }
    return false  // 未找到目标值
}
