package medium

/**
 * 找到字符串中所有字母异位词(哈希表,字符串,滑动窗口)
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串, 返回这些子串的起始索引, 顺序无关
 * 异位词指的是由相同的字母按照不同的顺序排列组成的单词或短语
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6] ("cba", "bac")
 */
fun findAnagrams(s: String, p: String): List<Int> {
    val result = mutableListOf<Int>() // 记录异位词的起始索引
    if (s.length < p.length) return result

    val pCount = IntArray(26) // 用于记录 p 中每个字符出现的次数(大小设为26)
    val windowCount = IntArray(26) // 用于记录当前窗口中每个字符出现的次数(大小设为26)

    for (i in p.indices) { // 遍历初始窗口中的字符(p的长度作为初始窗口)
        pCount[p[i] - 'a']++ // 要寻找p的异位词, 需先记录其所包含的字符及其频率, 例如"abc" -> [1,1,1,...]
        windowCount[s[i] - 'a']++ // 记录初始窗口中所包含的字符及其频率
    }

    // 如果初始窗口是p的异位词，记录其起始索引
    if (pCount.contentEquals(windowCount)) { result.add(0) }

    // p的长度作为初始窗口,s的长度作为全部区域, 窗口从p的右侧向s的右侧滑动, i为滑动窗口右侧索引
    for (i in p.length..<s.length) {
        windowCount[s[i] - 'a']++ // 右侧滑动时增加新字符，移入新字符, 更新窗口中字符的频率
        windowCount[s[i - p.length] - 'a']-- // 右侧滑动时移除最左侧旧字符, 更新窗口中字符的频率

        // 如果当前窗口是一个异位词，记录其起始索引
        if (pCount.contentEquals(windowCount)) { result.add(i - p.length + 1) }
    }
    return result
}
