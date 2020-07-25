package sort;

import com.alibaba.fastjson.JSON;

import java.util.stream.IntStream;

/**
 * 选择排序
 *      最初级的排序算法
 *      复杂度O(n)
 *
 * @author youchao.wen
 * @date 2020/7/2.
 */
public class SelectionSort {

    private static void sort(int[] array){
        int length = array.length;
        IntStream.range(0, length).forEach((indexOuter) -> {
            int num = array[indexOuter];
            //将array[indexOuter] 与 array[indexOuter + 1...length]中最小的元素交换
            IntStream.range(indexOuter + 1, length).forEach(indexInner -> {
                if(array[indexInner] <= array[indexOuter]){
                    //交换
                    int temp = array[indexInner];
                    array[indexInner] = array[indexOuter];
                    array[indexOuter] = temp;
                }
            });
        });
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 9, 10, 21, 4, 9, 0, 3, 100};
        sort(array);
        System.out.println("sorted -> " + JSON.toJSONString(array));
    }
}
