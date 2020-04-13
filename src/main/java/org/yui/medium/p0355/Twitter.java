package org.yui.medium.p0355;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0355
 * @description: 355. 设计推特
 * @author: YuI
 * @create: 2020/4/13 15:55
 **/
public class Twitter {

    private static class Message {
        int userId;
        int tweetId;
    }

    // 随时间推移存储消息
    List<Message> mMessageList;
    // 某用户关注了哪些人
    Map<Integer, Set<Integer>> mFollowMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        mMessageList = new LinkedList<>();
        mFollowMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Message message = new Message();
        message.userId = userId;
        message.tweetId = tweetId;
        mMessageList.add(0, message);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followeeSet = mFollowMap.computeIfAbsent(userId, k -> new HashSet<>());
        followeeSet.add(userId);

        List<Integer> news = mMessageList.stream()
                .filter(message -> followeeSet.contains(message.userId))
                .limit(10)
                .map(message -> message.tweetId)
                .collect(Collectors.toList());

        return news;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeSet;
        followeeSet = mFollowMap.computeIfAbsent(followerId, k -> new HashSet<>());

        followeeSet.add(followeeId);
        mFollowMap.put(followerId, followeeSet);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeSet;
        followeeSet = mFollowMap.computeIfAbsent(followerId, k -> new HashSet<>());

        followeeSet.remove(followeeId);
        mFollowMap.put(followerId, followeeSet);
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
