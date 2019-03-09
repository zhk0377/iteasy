package com.iteasy.linklist;

/**
 * @author kai.zheng
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019-03-09 09:27
 */
public class MyLinkList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkHeadCreate linkHeadCreate = new LinkHeadCreate();
        LinkTailCreate linkTailCreate = new LinkTailCreate();
        for (int i = 0; i < arr.length; i++) {
            linkHeadCreate.addHeadNode(arr[i]);
            linkTailCreate.addTailNode(arr[i]);
        }
        linkHeadCreate.getHead().showAllNodes();
        linkTailCreate.getHead().showAllNodes();
        //获取构造好的链表(不带空头)
        ListNode fristNode = linkHeadCreate.getHead().getNext();
        LinkListOperate operate = new LinkListOperate();
        System.out.print("循环反转链表前：");
        fristNode.showAllNodes();
        ListNode loopNodeHead=operate.reverseListByLoop(fristNode);
        System.out.print("循环反转链表后：");
        loopNodeHead.showAllNodes();
        ListNode recursionNodeHead = operate.reverseListByRecursion(loopNodeHead);
        System.out.print("递归反转链表后：");
        recursionNodeHead.showAllNodes();
    }
}
