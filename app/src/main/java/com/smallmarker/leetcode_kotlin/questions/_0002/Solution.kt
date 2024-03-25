package com.smallmarker.leetcode_kotlin.questions._0002

/**
 * @link https://leetcode.cn/problems/add-two-numbers/description/
 * @author   zl
 * @Date     2024/3/22
 **/
class Solution {

    // 创建一个新的链表用于存储结果。
    // 初始化两个指针，分别指向两个输入链表的头部。
    // 遍历两个链表，同时对两个链表的对应节点进行相加，并将结果存储到新链表中。
    // 需要注意的是，如果相加结果超过了 10，需要进位，将进位值加到下一个相加的节点上。
    // 如果其中一个链表遍历完毕后，另一个链表还有剩余节点，需要继续将剩余节点的值加到结果链表中。
    // 最后返回结果链表即可。
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var n1 = l1
        var n2 = l2
        var curr = dummyHead
        var curry = 0
        while (n1 != null || n2 != null) {
            val x = n1?.`val` ?: 0
            val y = n2?.`val` ?: 0
            val sum = x + y + curry
            curry = sum / 10
            curr.next = ListNode(sum % 10)
            curr = curr.next!!
            n1 = n1?.next
            n2 = n2?.next
        }
        if (curry > 0) {
            curr.next = ListNode(curry)
        }
        return dummyHead.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
