package com.cqyc.yiitong.util.binary;

/**
 * @author: cqyc
 * Description: 二分查找，寻找一个对象K在有序数组中
 * Created by cqyc on 19-10-20
 */
public class BinarySearched {
    public int binarySearch(int[] arr, int k) {
        int a = 0;
        int b = arr.length;

        //loop invariant:[a,b) is a valid range(a <= b)
        //key may only be with in range [a,b)
        while (a < b) {
///            int m = (a + b) / 2;
            //这里是由上面的替换，如果a和b很大，就会造成溢出
            int m = a + (b - a) / 2;
            if (k < arr[m]) {
                b = m;
            } else if (k > arr[m]) {
                a = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearched searched = new BinarySearched();
        int[] ints = {1, 2, 10, 15, 100};
        System.out.println(ints[searched.binarySearch(ints, 15)]);
    }
}
