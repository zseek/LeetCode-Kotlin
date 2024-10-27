package medium

/**
 * 无重复字符的最长子串(哈希表,双指针,滑动窗口)
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: s = "abcabcbb"
 * 输出: 3 ("abc")
 */
fun lengthOfLongestSubstring(s: String): Int {
    val map = mutableMapOf<Char, Int>() // 创建map记录字符最后一次出现的位置(字符, 索引)
    var maxLength = 0 // 最大子串长度
    var left = 0 // 左指针

    // 从左到右滑动窗口遍历字符串
    for (right in s.indices) {
        val char = s[right] // 当前遍历的字符
        // 出现重复字符(当前字符已在map中作为key被记录, 且上次被记录的位置在当前窗口内), 则更新左指针位置为上次出现的位置+1
        if (char in map && map[char]!! >= left) {
            left = map[char]!! + 1
        }
        map[char] = right // 无论是否重复, 更新map中该字符的位置(没有则添加)
        maxLength = maxOf(maxLength, right - left + 1) // 更新指针移动过程中最大子串长度
    }
    return maxLength
}

/*
// 右指针作为for循环的索引, 一直指向最前面的字符, 左指针作为每次窗口的最左侧, 保证不能与右指针指向的字符重复
map:          (a,0) -> (b,1) -> (c,2) -> (a,3) -> (b,4) -> (c,5) -> (b,6) -> (b,7)
(left,right): (0,0) -> (0,1) -> (0,2) -> (1,3) -> (2,4) -> (3,5) -> (5,6) -> (7,7)
maxLength:    1     -> 2     -> 3     -> 3     -> 3     -> 3     -> 2     -> 1

*/
