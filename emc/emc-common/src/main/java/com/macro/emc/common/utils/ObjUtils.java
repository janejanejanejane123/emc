//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.macro.emc.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjUtils {
    public static final Integer IdLength = 32;

    public ObjUtils() {
    }

    public static String[] checkObjFieldIsNull(Object obj) {
        if (obj == null) {
            return new String[0];
        } else {
            List<String> list = new ArrayList();

            try {
                Field[] var2 = obj.getClass().getDeclaredFields();
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    Field f = var2[var4];
                    f.setAccessible(true);
                    if (f.get(obj) == null || "".equals(f.get(obj))) {
                        list.add(f.getName());
                    }
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            return (String[])list.toArray(new String[0]);
        }
    }

    public static String[] checkObjFieldIsNull(Object obj, String[] strings) {
        String[] strings1 = checkObjFieldIsNull(obj);
        if (strings != null && strings.length != 0 && strings1.length != 0) {
            List<String> list = new ArrayList(Arrays.asList(strings1));
            list.removeAll(Arrays.asList(strings));
            return (String[])list.toArray(new String[0]);
        } else {
            return strings1;
        }
    }

    public static boolean isMobileDevice(String requestHeader) {
        String[] deviceArray = new String[]{"android", "ios", "windows phone"};
        if (requestHeader == null) {
            return false;
        } else {
            requestHeader = requestHeader.toLowerCase();

            for(int i = 0; i < deviceArray.length; ++i) {
                if (requestHeader.indexOf(deviceArray[i]) > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
