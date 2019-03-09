package com.iteasy.linklist;

/**
 * @author kai.zheng
 * @Description: 头插法创建
 * @date 2019-03-09 10:59
 */
public class LinkHeadCreate {
    private ListNode head;

    public LinkHeadCreate() {
        this.head = new ListNode();
    }

    void addHeadNode(int data) {
        ListNode node = new ListNode();
        node.setValue(data);
        node.setNext(head.getNext());
        head.setNext(node);
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }
}
