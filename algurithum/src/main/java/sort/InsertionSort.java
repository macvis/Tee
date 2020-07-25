package sort;

import com.alibaba.fastjson.JSON;

import java.util.stream.IntStream;

/**
 * 插入排序
 *  复杂度 O(n^2/4) ~ O(n^2/2)
 *
 * @author youchao.wen
 * @date 2020/7/2.
 */
public class InsertionSort {

    private static void sort(int[] array){
        int length = array.length;
        IntStream.range(0, length).forEach(indexOuter -> {
            //将array[indexOuter]插入到a[indexOuter - 1]、a[indexOuter - 2]...之中
            for(int j = indexOuter; j > 0 && (array[j] < array[j - 1]); j--){
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        });
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 9, 10, 21, 4, 9, 0, 3, 100};
        sort(array);
        System.out.println("sorted -> " + JSON.toJSONString(array));
    }
}
