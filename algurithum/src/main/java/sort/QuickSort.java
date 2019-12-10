package sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 * <p>
 * 从数组两端开始，设头端=i，尾端=k
 * 头尾两端都向中间遍历，
 * 0. 设置基准数，若设置头数为基准数，则要尾部先走；反之亦然
 * 1. 当head找到数大于i时，tail找到数小于k时，i与k的当前数交换位置
 * 2. i与k交换位置后，继续遍历
 * 3. 遍历结束后将head的数与基准数交换
 * 4. 递归遍历左半段
 * 5. 递归遍历右半段
 *
 * @author youchao.wen
 * @date 2019/10/22.
 */
public class QuickSort {

    private static void sort(int[] array, int head, int tail) {
        if (head > tail) {
            return;
        }

        int base = array[head];

        int i = head;
        int k = tail;
        while (i != k) {
            //因为设置了头部为基准数，则需要从尾部开始遍历
            while (array[k] >= base && i < k) {
                k--;
            }

            while (array[i] <= base && i < k) {
                i++;
            }

            //i与k交换
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }

        //遍历完成后将基准数与i交换
        array[head] = array[i];
        array[i] = base;

        sort(array, head, i - 1);
        sort(array, i + 1, tail);
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 9, 100, 10, 12, 24, 56, 7, 8, 3, 76};
        sort(array, 0, array.length - 1);

        System.out.println("array -> " + JSON.toJSONString(array));
    }
}
