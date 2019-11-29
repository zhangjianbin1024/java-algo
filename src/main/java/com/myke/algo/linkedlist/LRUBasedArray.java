package com.myke.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUBasedArray
 * <p>
 * 基于数组实现的LRU缓存(最近最少使用策略)
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 *
 * @Author: zhangjianbin
 * @Date: 2019/11/27 16:23
 */
public class LRUBasedArray<T> {
    //左移时不管正负，低位补0 : 1<<3 = 1000(二进制) = 8(十进制)
    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    // 缓存的个数
    private int count;

    private T[] value;

    //map 缓存容器: key: 访问的值 value:数组中的索引
    private Map<T, Integer> holder;


    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        //初始化 数组
        value = (T[]) new Object[capacity];
        count = 0;
        // 初始化一个 map,相当于 缓存的容器
        holder = new HashMap<T, Integer>(capacity);
    }


    /**
     * 模拟访问某个值
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        //从map 中获取 值,该值为数据中的索引
        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) { //缓存满的情况
                removeAndCache(object);//先移除后缓存
            } else {
                // 将 值 缓存
                cache(object, count);
            }
        } else {
            update(index); //在存缓存中时,则更新缓存中的索引
        }
    }


    /**
     * 若缓存中有指定的值，则更新位置
     *
     * @param end
     */
    public void update(int end) {
        //通过索引,获取数组中的值
        T target = value[end];
        rightShift(end);
        //将 target 存入 数据的头部
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存数据到头部，但要先右移
     *
     * @param object
     * @param end    数组右移的边界
     */
    public void cache(T object, int end) {
        rightShift(end);
        //要缓存的值,存入 数组的头部
        value[0] = object;
        //值存入缓存
        holder.put(object, 0);
        //记录缓存中的个数
        count++;
    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     *
     * @param object
     */
    public void removeAndCache(T object) {
        //获取最后一个值
        T key = value[--count];
        //从缓存中移除 key 值
        holder.remove(key);
        cache(object, count);
    }

    /**
     * end左边的数据统一右移一位
     *
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            //将值的索引 存入 缓存中
            holder.put(value[i], i + 1);
        }
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        // true 说明 缓存容量达到了上限
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }


    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
