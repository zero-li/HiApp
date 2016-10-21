package com.zeroli.commom.commonutils;

/**
 * Created by zhh_li on 2016/10/19.
 */

import java.util.Collection;

/**
 * 集合操作类
 */
public class CollectionUtil {

    public static boolean isNullOrEmpty(Collection c){
        if(c == null || c.isEmpty()){
            return true;
        }
        return false;
    }
}
