package com.jianzi.offer.study;

import com.jianzi.offer.study.common.ArrayUtils;
import com.jianzi.offer.study.strings.Strings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringsTests {
    @Test
    public void stringToIntSuccess() {
        String s = "12345678";

        Integer[] arry = assertDoesNotThrow(() -> Strings.stringToInt(s));

        ArrayUtils.println(arry);
    }

    @Test
    public void stringToIntFail() {
        String s = "123ab45678";

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Integer[] arry = Strings.stringToInt(s);
            ArrayUtils.println(arry);
        });

        assertEquals("非数字字符报错", exception.getMessage());
    }
}
