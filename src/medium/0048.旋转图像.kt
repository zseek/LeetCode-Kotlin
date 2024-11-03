package medium

/**
 * 旋转图像(数组,矩阵,数学)
 * https://leetcode.cn/problems/rotate-image
 * 给定一个 n * n 的二维矩阵 matrix 表示一个图像, 将图像顺时针旋转90度(必须原地修改输入矩阵)
 * 输入: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出: [[7,4,1],[8,5,2],[9,6,3]]
 */
fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size

    // 矩阵转置(行变列,列变行), 即按对角线(左上-右下)交换元素
    for (i in 0..<n) {
        for (j in i + 1..<n) {
            // 交换 matrix[i][j] 和 matrix[j][i]
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    // 翻转每一行(将每一行的元素顺序颠倒)
    for (i in 0..<n) {
        matrix[i].reverse()
    }
}
