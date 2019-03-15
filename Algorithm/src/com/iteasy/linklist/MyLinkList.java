package com.iteasy.linklist;

/**
 * @author kai.zheng
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019-03-09 09:27
 */
public class MyLinkList {
    public static void main(String[] args) {
        LinkListOperate operate = new LinkListOperate();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkHeadCreate linkHeadCreate = new LinkHeadCreate();
        LinkTailCreate linkTailCreate = new LinkTailCreate();
        for (int i = 0; i < arr.length; i++) {
            linkHeadCreate.addHeadNode(arr[i]);
            linkTailCreate.addTailNode(arr[i]);
        }
        /**两种链表创建方式**/
        linkHeadCreate.getHead().showAllNodes();
        linkTailCreate.getHead().showAllNodes();
        //获取构造好的链表(不带空头)
        ListNode fristNode = linkHeadCreate.getHead().getNext();

        /** 两种链表反转方式**/
        System.out.print("循环反转链表前：");
        fristNode.showAllNodes();
        ListNode loopNodeHead=operate.reverseListByLoop(fristNode);
        System.out.print("循环反转链表后：");
        loopNodeHead.showAllNodes();
        ListNode recursionNodeHead = operate.reverseListByRecursion(loopNodeHead);
        System.out.print("递归反转链表后：");
        recursionNodeHead.showAllNodes();

        /** 判断回文 **/
        int[] plalindromeArr = {1, 2, 3, 4, 5,5, 4, 3, 2, 1};
        LinkHeadCreate temPlalindromeLink = new LinkHeadCreate();
        for (int i = 0; i < plalindromeArr.length; i++) {
            temPlalindromeLink.addHeadNode(plalindromeArr[i]);
        }
        ListNode plalindromeLink=temPlalindromeLink.getHead().getNext();
        plalindromeLink.showAllNodes();
        System.out.println("是否是回文-->"+operate.isPalindrome(plalindromeLink));
    }


}
