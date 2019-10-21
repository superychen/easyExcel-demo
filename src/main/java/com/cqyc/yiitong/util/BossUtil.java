package com.cqyc.yiitong.util;

/**
 * @author: cqyc
 * Description:
 * Created by cqyc on 19-10-16
 */
public class BossUtil {

    /**
     * 写一个函数， 2个参数， 1个字符串， 1个字节数，返回截取的字符串，
     * 要 求字符串中的中文不能出现乱码： 如 （ “ 我ABC”， 4） 应该截为 “ 我AB”，输入（ “ 我 ABC汉DEF”， 6
     */
    public String subString(String str, int subBytes) {
        int bytes = 0;
        for (int i = 0; i < str.length(); i++) {
            if (bytes == subBytes) {
                return str.substring(0, i);
            }
            char c = str.charAt(i);
            System.out.println("c = " + c);
            if (c < 256) {
                //英文字符的字节数看做为1
                bytes += 1;
            } else {
                //中文字符的字节数看作2
                bytes += 2;
            }
            if (bytes - subBytes == 1) {
                return str.substring(0, i);
            }
        }
        return str;
    }

}
