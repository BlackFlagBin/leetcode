package problem347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
347. 前K个高频元素

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

例如，

给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。

注意：

你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */

class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count - o2.count;
            }
        });
        ArrayList<Integer> resultList = new ArrayList<>();

        //统计数字的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], value + 1);
            }
        }

        //保持优先队列的size为k
        for (Integer integer : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new Node(integer, map.get(integer)));
            } else {
                Node node = queue.peek();
                if (node.count < map.get(integer)) {
                    queue.poll();
                    queue.add(new Node(integer, map.get(integer)));
                }
            }
        }

        for (Node aQueue : queue) {
            resultList.add(aQueue.num);
        }

        return resultList;
    }

    private class Node {
        private int num;
        private int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}