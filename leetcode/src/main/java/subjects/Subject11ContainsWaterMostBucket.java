package subjects;

/**
 * 盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *  本质上是，求面积最大值，即找到 下表间距 * 两个最大值中较小值 的最大值
 *
 * @author youchao.wen
 * @date 2020/6/10.
 */
public class Subject11ContainsWaterMostBucket {
    public static int solve(int[] height){
        int square = 0;
        for(int i = 0; i < height.length; i ++){
            int numIndex = height[i];
            for(int j = i + 1; j < height.length; j++){
                int numJIndex = height[j];
                int steps = j - i;
                square = Math.max(Math.min(numIndex, numJIndex) * steps, square);
            }
        }

        return square;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
