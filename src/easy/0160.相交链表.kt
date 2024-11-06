package easy

/**
 * 相交链表(链表,双指针,哈希表)
 * https://leetcode.cn/problems/intersection-of-two-linked-lists
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null, 在返回结果后，两个链表仍须保持原有的结构, 题目数据中整个链式结构不存在环
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 */
//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null

    // 定义指针指定链表头部
    var pA = headA
    var pB = headB

    // 遍历两个链表, 每个指针到达各自链表末尾后, 切换到另一个链表继续遍历,直到它们相交
    while (pA != pB) {
        pA = if (pA == null) headB else pA.next
        pB = if (pB == null) headA else pB.next
    }
    return pA // 返回相交节点或 null
}
