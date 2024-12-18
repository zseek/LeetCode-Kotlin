package medium

/**
 * 螺旋矩阵(模拟,数组,矩阵)
 * https://leetcode.cn/problems/spiral-matrix
 * 给你一个 m 行 n 列的矩阵 matrix, 请按照顺时针螺旋顺序, 返回矩阵中的所有元素
 * 输入: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出: [1,2,3,6,9,8,7,4,5]
 */
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return emptyList() // 如果矩阵为空，返回空列表

    val result = mutableListOf<Int>()
    var top = 0 // 上边界
    var bottom = matrix.size - 1 // 下边界
    var left = 0 // 左边界
    var right = matrix[0].size - 1 // 右边界

    while (top <= bottom && left <= right) { // 控制遍历边界

        // 从左到右遍历上边界
        for (i in left..right) {
            result.add(matrix[top][i]) // [0,0],[0,1],[0,2]
        }
        top++ // 遍历完上边界后，收缩上边界, 例如3*3 -> 2*3

        // 从上到下遍历右边界
        for (i in top..bottom) {
            result.add(matrix[i][right]) // [1,2],[2,2]
        }
        right-- // 遍历完右边界后，收缩右边界, 例如2*3 -> 2*2

        // 检查是否还有下边界和左边界需要遍历
        if (top <= bottom) {
            // 从右到左遍历下边界
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom-- // 遍历完下边界后，收缩下边界, 例如2*2 -> 1*2
        }

        if (left <= right) {
            // 从下到上遍历左边界
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++ // 遍历完左边界后，收缩左边界, 例如1*2 -> 1*1
        }
    }
    return result
}
