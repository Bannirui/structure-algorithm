import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * @Author: dingRui
 * @Date: 2021-08-10 10:09:30
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-10 10:54:32
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 */

// @lc code=start
class Twitter {

    // 用户信息
    private static class UserInfo {
        // 用户关注的
        private Set<Integer> followee;
        // 用户的发文
        private List<Integer> tweet;

        public UserInfo() {
            this.followee = new HashSet<Integer>();
            this.tweet = new ArrayList<Integer>();
        }
    }

    // 发文信息
    private static class TweetInfo {
        // 发文id
        private Integer tweetId;
        // 发文时间
        private Integer time;

        public TweetInfo(Integer tweetId, Integer time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    // 发文时间
    private int time;
    // 看发文的最多数量
    private int tweetMax;

    // 所有用户
    private Map<Integer, UserInfo> users;

    // 所有发文
    private Map<Integer, TweetInfo> tweets;

    /** Initialize your data structure here. */
    public Twitter() {
        this.time = 0;
        this.tweetMax = 10;
        this.users = new HashMap<Integer, UserInfo>();
        this.tweets = new HashMap<Integer, TweetInfo>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            // 用户不存在 先创建该用户
            users.put(userId, new UserInfo());
        }
        // 用户发文数量
        int curCounts = this.users.get(userId).tweet.size();
        if (curCounts == this.tweetMax) {
            // 删掉发文
            this.users.get(userId).tweet.remove(this.tweetMax - 1);
        }
        this.users.get(userId).tweet.add(0, tweetId);
        // 维护发文信息
        this.tweets.put(tweetId, new TweetInfo(tweetId, ++this.time));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // 最新10篇发文
        Queue<TweetInfo> smallHeap = new PriorityQueue<>((o1, o2) -> {
            // 发文时间升序
            return o1.time - o2.time;
        });
        // 自己与关注的所有发文
        UserInfo userInfo = this.users.get(userId);
        if (userInfo == null) {
            return Collections.emptyList();
        }
        // 自己的发文
        List<TweetInfo> selfTweetList = this.getTweetListByUserId(userId);
        // 关注者的发文
        List<TweetInfo> followeeTweetList = new ArrayList<>();
        for (Integer followeeId : userInfo.followee) {
            if (followeeId == userId) {
                continue;
            }
            followeeTweetList.addAll(this.getTweetListByUserId(followeeId));
        }
        // 往堆里面放
        selfTweetList.addAll(followeeTweetList);
        for (TweetInfo tweetInfo : selfTweetList) {
            if (smallHeap.size() == this.tweetMax) {
                smallHeap.poll();
            }
            smallHeap.offer(tweetInfo);
        }
        // 取出最近10个发文
        List<Integer> res = new ArrayList<>();
        while (!smallHeap.isEmpty()) {
            // 小根堆取出来的顺序是发文时间升序 需要结果列表中降序
            res.add(0, smallHeap.poll().tweetId);
        }
        return res;
    }

    private List<TweetInfo> getTweetListByUserId(Integer userId) {
        List<TweetInfo> tweetList = new ArrayList<>();
        UserInfo userInfo = this.users.get(userId);
        if (userInfo == null) {
            return Collections.emptyList();
        }
        // 自己的发文
        for (Integer tweetId : userInfo.tweet) {
            TweetInfo tweetInfo = this.tweets.get(tweetId);
            if (tweetInfo != null) {
                tweetList.add(tweetInfo);
            }
        }
        return tweetList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        // 用户是否存在
        if (!this.users.containsKey(followerId)) {
            // 用户不存在 先创建该用户
            this.users.put(followerId, new UserInfo());
        }
        if (!this.users.containsKey(followeeId)) {
            // 用户不存在 先创建该用户
            this.users.put(followeeId, new UserInfo());
        }
        // 关注用户
        this.users.get(followerId).followee.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        // 用户是否存在
        if (!this.users.containsKey(followerId)) {
            // 用户不存在 先创建该用户
            this.users.put(followerId, new UserInfo());
        }
        this.users.get(followerId).followee.remove(followeeId);
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
// @lc code=end
