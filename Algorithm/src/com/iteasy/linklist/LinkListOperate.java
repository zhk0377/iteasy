package com.iteasy.linklist;

/**
 * @author kai.zheng
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019-03-09 11:27
 */
public class LinkListOperate{

    public ListNode reverseListByLoop(ListNode fristNode) {
        if(fristNode==null || fristNode.getNext()==null){
            return fristNode;
        }
        ListNode pre=fristNode;
        ListNode curr=fristNode.getNext();
        fristNode.setNext(null);
        while(curr!=null){
            ListNode tem=curr.getNext();
            curr.setNext(pre);
            pre=curr;
            curr=tem;
        }
        return pre;
    }

    public ListNode reverseListByRecursion(ListNode fristNode) {
        if(fristNode==null || fristNode.getNext()==null){
            return fristNode;
        }
        ListNode  reHead = reverseListByRecursion(fristNode.getNext());// 先反转后续节点head.getNext()
        fristNode.getNext().setNext(fristNode);// 将当前结点的指针域指向前一结点
        fristNode.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }
}
