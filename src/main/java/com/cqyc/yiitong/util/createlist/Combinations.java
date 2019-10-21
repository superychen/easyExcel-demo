package com.cqyc.yiitong.util.createlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: cqyc
 * Description: 给列表分组
 * Created by cqyc on 19-10-18
 */
public class Combinations {
    public void combinations(
            List<Integer> selected, List<Integer> data, int n) {

        if (n == 0) {
            for (Integer i : selected) {
                System.out.println(i);
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()) {
            return;
        }
        //第0个元素
        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n - 1);

        //不选择第0个元素
        selected.remove(selected.size() - 1);
        combinations(selected, data.subList(1, data.size()), n);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 2);
        combinations.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4, 5, 7), 3);
    }
}
