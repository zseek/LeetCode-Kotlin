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

fun reverseList(head: ListNode?): ListNode? {
    // 递归终止条件：链表为空或只有一个节点
    if (head == null || head.next == null) {
        return head
    }

    // 递归反转剩余链表，返回新的头节点
    val newHead = reverseList(head.next)

    // 反转当前节点和它的下一个节点的指向
    head.next?.next = head // 将 head.next 的 next 指向当前节点 head
    head.next = null // 将当前节点的 next 置为空，断开原始链接

    return newHead // 返回反转后的新头节点
}
