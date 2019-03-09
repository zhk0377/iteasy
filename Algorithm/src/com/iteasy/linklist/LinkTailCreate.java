package com.iteasy.linklist;

/**
 * @author kai.zheng
 * @Description: 尾插法创建
 * @date 2019-03-09 11:11
 */
public class LinkTailCreate {
    private ListNode head ;
    private ListNode tail;

    public LinkTailCreate() {
        this.head=new ListNode();
        this.tail = head;
    }

    void addTailNode(int data){
        ListNode node=new ListNode();
        node.setValue(data);
        tail.setNext(node);
        tail=node;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode getTail() {
        return tail;
    }

    public void setTail(ListNode tail) {
        this.tail = tail;
    }
}
