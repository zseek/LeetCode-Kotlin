package medium

/**
 * 合并区间(数组,排序)
 * https://leetcode.cn/problems/merge-intervals
 * 给出一个区间的集合, 请合并所有重叠的区间。
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()

    // 按区间起始值进行排序
    intervals.sortBy { it[0] }
    // 用于存储合并后的区间
    val merged = mutableListOf<IntArray>()

    for (interval in intervals) {
        // merged区间为空, 或当前区间与merged最后一个区间不重叠, 则合并区间
        if (merged.isEmpty() || merged.last()[1] < interval[0]) {
            merged.add(interval)
        } else {
            // 有重叠, 更新merged最后一个区间的结束值
            merged.last()[1] = maxOf(merged.last()[1], interval[1])
        }
    }
    return merged.toTypedArray()
}


