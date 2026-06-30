class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending{ it })
        for (num in nums) {
            maxHeap.offer(num)
        }

        var currMax = 0
        repeat(k) {
            currMax = maxHeap.poll()
        }
        return currMax
    }
}
