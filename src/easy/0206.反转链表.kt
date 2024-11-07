package easy

/**
 * 反转链表(递归,链表)
 * https://leetcode.cn/problems/reverse-linked-list/
 * 给你单链表的头节点 head, 请你反转链表, 并返回反转后的链表
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// 迭代法: 原始的链表时从左向右指向的, 通过将链表顺序逐步更改为从右向左指向, 实现链表的反转
fun reverseList(head: ListNode?): ListNode? {
    var curNode = head             // 当前处理的节点, 初始为头节点
    var preNode: ListNode? = null  // 已反转部分的最后一个节点, 初始为null

    if (curNode == null) return null // 如果链表为空则直接返回null

    // 遍历整个链表
    while (curNode != null) {
        val nextNode = curNode.next // 保存当前节点的下一个节点
        curNode.next = preNode      // 将当前节点的next反向指向preNode
        preNode = curNode           // 将preNode移动到当前节点
        curNode = nextNode          // 将curNode移动到下一个节点, 继续循环
    }
    // 当循环结束时, preNode指向新的头节点
    return preNode
}



