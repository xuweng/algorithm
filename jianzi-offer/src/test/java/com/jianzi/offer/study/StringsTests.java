package com.jianzi.offer.study;

import com.jianzi.offer.study.common.ArrayUtils;
import com.jianzi.offer.study.common.annotation.ExceptionUserCase;
import com.jianzi.offer.study.common.annotation.NormalUserCase;
import com.jianzi.offer.study.strings.Strings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringsTests {
    @NormalUserCase
    @Test
    public void stringToIntSuccess() {
        String s = "12345678";

        Integer[] arry = assertDoesNotThrow(() -> Strings.stringToInt(s));

        ArrayUtils.println(arry);
    }

    /**
     * 非数字字符报错
     */
    @ExceptionUserCase
    @Test
    public void stringToIntFail() {
        String s = "123ab45678";

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Integer[] arry = Strings.stringToInt(s);
            ArrayUtils.println(arry);
        });

        assertEquals("非数字字符报错", exception.getMessage());
    }

    /**
     * 空指针
     */
    @ExceptionUserCase
    @Test
    public void stringToIntFail1() {
        String s = null;

        Throwable exception = assertThrows(NullPointerException.class, () -> {
            Integer[] arry = Strings.stringToInt(s);
            ArrayUtils.println(arry);
        });
    }

    @NormalUserCase
    @Test
    public void replaceBlankSuccess() {
        String s = "i am happy.#**********";
        char[] array = s.toCharArray();
        assertDoesNotThrow(() -> Strings.replaceBlank(array, array.length));

        System.out.println(new String(array));
    }

    @NormalUserCase
    @Test
    public void replaceBlankSuccess1() {
        String s = "iamhappy.#**********";
        char[] array = s.toCharArray();
        assertDoesNotThrow(() -> Strings.replaceBlank(array, array.length));

        System.out.println(new String(array));
    }
}
