class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        // If there is only one store
        if (stones.size == 1) {
            return stones[0]
        }
        
        // Let's have maxHeap and fill up all the elements
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (stone in stones) {
            maxHeap.offer(stone)
        }

        // Find the difference and add it to the maxHeap until the last stone remains
        while (maxHeap.size > 1) {
            val firstMax = maxHeap.poll()
            val secondMax = maxHeap.poll()

            val difference = firstMax - secondMax
            if (difference > 0) {
                maxHeap.offer(difference)
            }
        }

        return if (maxHeap.size == 0) {
            0
        } else {
            maxHeap.poll() // return the last element's weight
        }
    }
}
