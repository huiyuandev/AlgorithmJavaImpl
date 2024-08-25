package binary_search;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找基础版
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回目标值索引
     * 找不到返回-1
     */
    public static int binarySearchBasis(int[] a, int target) {
        // 设置指针和初值
        int i = 0, j = a.length - 1;
        // 范围内有东西
        while (i <= j) {
            // 移位运算：避免数据溢出
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                // 目标在左边
                j = m - 1;
            } else if (a[m] < target) {
                // 目标在右边
                i = m + 1;
            } else {
                // bingo
                return m;
            }
        }
        return -1;
    }

    /**
     * 问题1：为什么是 i <= j 意味着区间内有未比较的元素，而不是 i < j
     * i，j指向的元素也会参与比较
     *
     * 问题2：(i + j) / 2 有没有问题
     * 问题3：都写成小于号有啥好处
     */


}
