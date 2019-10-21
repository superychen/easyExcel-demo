package com.cqyc.yiitong;

import com.cqyc.yiitong.util.BossUtil;
import org.junit.Test;

/**
 * @author: cqyc
 * Description:
 * Created by cqyc on 19-10-16
 */
public class SeeBoss {

    /**
     * 写一个函数， 2个参数， 1个字符串， 1个字节数，返回截取的字符串，
     * 要 求字符串中的中文不能出现乱码： 如 （ “ 我ABC”， 4） 应该截为 “ 我AB”，输入（ “ 我 ABC汉DEF”， 6
     */
    @Test
    public void test1() {
        BossUtil bossUtil = new BossUtil();
        String s = bossUtil.subString("我 ABC汉DEF", 6);
        System.out.println("s = " + s);
    }

    /**
     * 用最有效率的方法算出2乘以8等于几
     */
    @Test
    public void test2() {
        // 因为将一个数左移n位，就相当于乘以了2的n次方，
        //那么，一个数乘以8只要将其左移3位即可，而位运算cpu直接支持的，效率最高，
        //所以，2乘以8等於几的最效率的方法是2 << 3。
        System.out.println(2 < 3);
        //2*2^3 = 16
        System.out.println(2 << 3);
        //3*2^3 = 24
        System.out.println(3 << 3);
        //1*2^2 = 4
        System.out.println(1 << 2);
    }

}
