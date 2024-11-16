package medium

/**
 * 搜索二维矩阵II(数组,二分查找,分治,矩阵)
 * https://leetcode.cn/problems/search-a-2d-matrix-ii
 * 编写一个高效的算法来搜索 m x n 矩阵matrix中是否存在一个目标值 target, 该矩阵具有以下特性:每行的元素从左到右升序排列, 每列的元素从上到下升序排列
 * 输入: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出: true
 */
private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    if (matrix.isEmpty() || matrix[0].isEmpty()) return false // 矩阵为空时直接返回 false

    // 右上 -> 左下搜索(row递增数增大,col递减数减小)
    var row = 0
    var col = matrix[0].size - 1

    while (row < matrix.size && col >= 0) {
        when {
            matrix[row][col] == target -> return true // 找到目标值，返回 true
            matrix[row][col] > target -> col-- // 当前值大于目标, 继续col--使数变小
            matrix[row][col] < target -> row++ // 当前值小于目标, 继续row++使数变大
        }
    }
    return false // 未找到目标值，返回 false
}
