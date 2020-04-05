package org.yui.hard.p0460;

/**
 * @program: leetcode
 * @package: org.yui.hard.p0460
 * @description: 460. LFU缓存
 * @author: YuI
 * @create: 2020/4/5 23:14
 **/
public class Solution {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
