package com.liqiwen.media.util;

public final class StringUtil {

    private StringUtil() {
        super();
    }

    public static boolean isEmpty(String str) {
        if(str == null) {
            return true;
        }
        return "".equals(str) || str.trim().length() == 0;
    }


    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
