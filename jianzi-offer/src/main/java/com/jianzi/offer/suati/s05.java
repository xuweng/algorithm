package com.jianzi.offer.suati;

/**
 * 面试题05. 替换空格
 */
public class s05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        char[] arry = s.toCharArray();
        int count = 0;
        for (char c : arry) {
            if ((' ' == c)) {
                count++;
            }
        }

        char[] newArray = new char[arry.length + count * 2];
        int i = arry.length - 1;
        int j = newArray.length - 1;

        for (int k = j; k >= 0 && i >= 0; i--) {
            if (' ' == arry[i]) {
                newArray[k--] = '0';
                newArray[k--] = '2';
                newArray[k--] = '%';
            } else {
                newArray[k--] = arry[i];
            }
        }

        return new String(newArray);
    }
}
