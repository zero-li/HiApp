package com.zeroli.common.commonutils;

/**
 * Created by zhh_li on 2016/10/19.
 */

import java.util.Collection;

/**
 * 集合操作类
 */
public class CollectionUtil {

    /**
     * 判断集合是否为null或者0个元素
     *
     * @param c
     * @return
     */
    public static boolean isNullOrEmpty(Collection c){
        if(c == null || c.isEmpty()){
            return true;
        }
        return false;
    }
}
