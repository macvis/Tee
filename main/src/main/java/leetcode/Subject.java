package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leet code 刷题、解题
 *
 * @author youchao.wen
 * @date 2019-05-15.
 */
public class Subject {
    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static class TwoSums1 {

        public static int[] solve1(int nums[], int target) {
            //1. 暴力破解法
            int result[] = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }

            return null;
        }

        public static int[] solve2(int nums[], int target) {
            //2. 使用map
            Map<Integer, Integer> map = new HashMap<>(16);
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], i);
                int remain = target - nums[i];
                if (map.containsKey(remain)) {
                    result[0] = map.get(remain);
                    result[1] = i;
                }
            }
            System.out.println("map -> " + map);

            return result;
        }
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static class TwoSums2 {
        public ListNode solve1(ListNode node1, ListNode node2) {
            Integer val1 = Integer.parseInt(stringify(node1));
            Integer val2 = Integer.parseInt(stringify(node2));

            int sum = val1 + val2;
            return toNode(sum);
        }

        private String stringify(ListNode node) {
            StringBuilder val = new StringBuilder();
            ListNode temp = node;
            while (temp != null) {
                val.append(temp.val);
                temp = temp.next;
            }
            return val.reverse().toString();
        }

        public static ListNode toNode(int val) {
            String str = new StringBuilder(val + "").reverse().toString();
            int index = 0;
            int length = str.length();
            String temp = str.substring(index, index + 1);
            int num = Integer.parseInt(temp);
            ListNode node = new ListNode(num);
            ListNode tmp = node;
            while (tmp != null){
                index ++;
                if(index + 1 <= length && temp != null){
                    temp = str.substring(index, index + 1);
                    num = Integer.parseInt(temp);
                    tmp.next = new ListNode(num);
                    node.next = tmp;

                    tmp = tmp.next;
                }else{
                    tmp = null;
                }
            }

            return node;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder builder = new StringBuilder(this.val);
            while (node.next != null) {
                node = node.next;
                builder.append(" -> ").append(node.val);
            }

            return builder.toString();
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15, 0, 20, 21};
//        int target = 41;
//        int[] result = TwoSums1.solve2(nums, target);
//        System.out.println("result -> " + result[0] + ", " + result[1]);

        int val1 = 123;
        ListNode node = TwoSums2.toNode(val1);
        System.out.println("node -> " + node);
    }
}
