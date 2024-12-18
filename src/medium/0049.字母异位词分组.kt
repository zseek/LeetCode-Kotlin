package medium

/**
 * 字母异位词分组(哈希表,字符串,排序,数组)
 * https://leetcode.cn/problems/group-anagrams/
 * 给定一个字符串数组,将字母异位词组合在一起。字母异位词指字母相同,但排列不同的字符串
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>() // 创建哈希表，用来将异位词分组
    for (str in strs) { // 遍历每一个字符串
        val sortedStr = str.toCharArray().sorted().joinToString("") // 将每一个字符串转为字符数组，排序后转回字符串
        if (sortedStr !in map) { // 若排序后的字符串不在哈希表中则将其作为键作加入其中(异位词排序后相同,可作为键代表异位词)
            map[sortedStr] = mutableListOf() // 为键创建一个空列表作为值存储异位词
        }
        map[sortedStr]?.add(str) // 将当前字符串加入到对应键的异位词列表中
    }
    return map.values.toList() // 返回分组结果
}


