package medium

/**
 * 无重复字符的最长子串(哈希表,双指针,滑动窗口)
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: s = "abcabcbb"
 * 输出: 3 ("abc")
 */
fun lengthOfLongestSubstring(s: String): Int {
    val charIndexMap = mutableMapOf<Char, Int>() // 创建哈希表存储(字符, 索引)
    var maxLength = 0 // 最大子串长度
    var left = 0 // 左指针

    for (right in s.indices) {
        val currentChar = s[right] // 当前索引字符
        // 若当前字符已在哈希表中, 且其索引大于左指针, 则更新左指针位置
        if (currentChar in charIndexMap && charIndexMap[currentChar]!! >= left) {
            left = charIndexMap[currentChar]!! + 1
        }
        charIndexMap[currentChar] = right // 更新当前字符的索引
        maxLength = maxOf(maxLength, right - left + 1) // 更新最大子串长度
    }
    return maxLength
}

