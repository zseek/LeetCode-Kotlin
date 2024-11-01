package medium

/**
 * 矩阵置零(数组,哈希表,矩阵)
 * https://leetcode.cn/problems/set-matrix-zeroes
 * 给定一个 m * n 的矩阵, 如果一个元素为 0, 则将其所在行和列的所有元素都设为 0. 请使用原地算法
 * 输入: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出: [[1,0,1],[0,0,0],[1,0,1]]
 */
fun setZeroes(matrix: Array<IntArray>) {
    val m = matrix.size
    val n = matrix[0].size

    var firstRowZero = false
    var firstColZero = false

    // 标记第一行是否有零
    for (j in 0..<n) {
        if (matrix[0][j] == 0) {
            firstRowZero = true
            break
        }
    }
    // 标记第一列是否有零
    for (i in 0..<m) {
        if (matrix[i][0] == 0) {
            firstColZero = true
            break
        }
    }
    // 使用第一行和第一列标记该行列中是否有零
    for (i in 1..<m) {
        for (j in 1..<n) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }
    // 遍历每个矩阵元素, 检查所在行列是否为归零行列, 是则进行归零处理(第一行/列作为标记位, 不需要处理)
    for (i in 1..<m) {
        for (j in 1..< n) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
    }
    // 最后处理: 根据第一行/列是否有零来对其进行置零
    if (firstRowZero) for (j in 0..<n) { matrix[0][j] = 0 }
    if (firstColZero) for (i in 0..<m) { matrix[i][0] = 0 }
}

