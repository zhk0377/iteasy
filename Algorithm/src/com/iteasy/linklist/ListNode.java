package com.iteasy.linklist;

/**
 * @author kai.zheng
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019-03-09 14:36
 */
public class ListNode {
    private ListNode next;
    private Integer value;
    public void showAllNodes(){
        ListNode curr=this;
        while(curr!=null){
            System.out.print(curr.getValue()+"\t");
            curr=curr.next;
        }
        System.out.println();
    }
    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
