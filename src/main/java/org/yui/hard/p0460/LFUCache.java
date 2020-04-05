package org.yui.hard.p0460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @program: leetcode
 * @package: org.yui.hard.p0460
 * @description: 460. LFU缓存
 * @author: YuI
 * @create: 2020/4/5 22:23
 **/
public class LFUCache {

    Map<Integer, Node> cache;                       // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> mapLinked;    // 存储每个频次对应的双向链表
    int capacity;                                   // 最大容量
    int min;                                        // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        mapLinked = new HashMap<>();
        this.capacity = capacity;
        min = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        updateLinked(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            updateLinked(node);
        } else {
            if (cache.size() == capacity) {
                Node deleteNode = deleteLinked();
                cache.remove(deleteNode.key);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addLinked(newNode);
        }

    }

    private void addLinked(Node node) {
        LinkedHashSet<Node> links = mapLinked.computeIfAbsent(1, k -> new LinkedHashSet<>());
        links.add(node);

        min = 1;
    }

    private void updateLinked(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> links = mapLinked.get(freq);
        links.remove(node);
        if (freq == min && links.size() == 0) {
            min = freq + 1;
        }

        // 加入到新的freqMap中
        node.freq++;
        LinkedHashSet<Node> newLinks = mapLinked.computeIfAbsent(node.freq, k -> new LinkedHashSet<>());
        newLinks.add(node);
    }

    private Node deleteLinked() {
        LinkedHashSet<Node> deleteLinks = mapLinked.get(min);
        Node deleteNode = deleteLinks.iterator().next();

        deleteLinks.remove(deleteNode);
        return deleteNode;
    }
}

class Node {
    public int key;
    public int value;
    public int freq;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}