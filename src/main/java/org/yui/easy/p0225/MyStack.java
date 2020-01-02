package org.yui.easy.p0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 *
 * @program: leetcode
 * @description: 225.用队列实现栈
 * @author: yui
 * @create: 2020-01-03 00:17
 **/
public class MyStack {

    Queue<Integer> pushQueue;
    Queue<Integer> popQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        pushQueue = new LinkedList<>();
        popQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        pushQueue.offer(x);
        while (!popQueue.isEmpty()) {
            pushQueue.offer(popQueue.poll());
        }
        while (!pushQueue.isEmpty()) {
            popQueue.offer(pushQueue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return popQueue.peek() == null ? -1 : popQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return popQueue.peek() == null ? -1 : popQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return popQueue.isEmpty();
    }
}
