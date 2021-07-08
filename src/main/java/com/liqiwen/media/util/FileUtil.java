package com.liqiwen.media.util;

public final class FileUtil {

    private FileUtil() {

    }


    public static String getFilename(String file) {
        if(file == null || "".equals(file.trim())) {
            return null;
        }
        return file.substring(0, file.lastIndexOf("."));
    }

    public static String getFileExtension(String file) {
       if(file == null || "".equals(file.trim())) {
           return null;
       }
       return file.substring(file.lastIndexOf(".")).toLowerCase();
    }

}
